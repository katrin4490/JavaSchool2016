package ru.sbertech.homework.JDBC_lesson21;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.concurrent.ConcurrentHashMap;

public class CachedProxy {
    static final class Args {
        private final Method mMethod;
        private final Object[] mArgs;
        private final int mHash;

        public Args(final Method m, final Object[] args) {
            mMethod = m;
            mArgs = args;
            mHash = calcHash();
        }
        @Override
        public boolean equals(final Object obj) {
            final Args other = (Args) obj;
            if (!mMethod.equals(other.mMethod)) {
                return false;
            }
            for (int i = 0; i < mArgs.length; ++i) {
                Object o1 = mArgs[i];
                Object o2 = other.mArgs[i];
                if (!(o1 == null ? o2 == null : o1.equals(o2))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return mHash;
        }

        private int calcHash() {
            int h = mMethod.hashCode();
            for (final Object o : mArgs) {
                h = h + (o == null ? 0 : o.hashCode());
            }
            return h;
        }
    }

    public static <T> T create(final Class<T> cl, final T code) {
        final ConcurrentHashMap<Args, Object> argsToOutput = new ConcurrentHashMap<Args, Object>();

        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[] { cl }, new InvocationHandler() {

            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                final Args input = new Args(method, args);
                Object result = argsToOutput.get(input);
                if (result == null && !argsToOutput.containsKey(input)) {
                    try {
                        if (args.length == 2) {
                            try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

                                PreparedStatement preparedStatement = conn.prepareStatement("select * from cache where PARAM1 = ? and PARAM2 = ?");
                                preparedStatement.setString(1, args[0].toString());
                                preparedStatement.setString(2, args[1].toString());
                                ResultSet resultSet = preparedStatement.executeQuery();
                                if (resultSet.next()) {
                                    System.out.println("cach from database:");
                                    result = resultSet.getObject("RESULT");
                                } else {
                                    result = method.invoke(code, args);
                                    preparedStatement = conn.prepareStatement("insert into cache values(?, ?, ?)");
                                    preparedStatement.setString(1, args[0].toString());
                                    preparedStatement.setString(2, args[1].toString());
                                    preparedStatement.setString(3, result.toString());
                                    preparedStatement.execute();
                                }
                                conn.close();
                            }
                        } else {
                            result = method.invoke(code, args);
                        }
                        argsToOutput.put(input, result);

                    } catch (InvocationTargetException e) {
                        throw e.getTargetException();
                    }
                }
                else {
                    System.out.println("cach:");
                }
                return result;
            }
        });
    }
}
