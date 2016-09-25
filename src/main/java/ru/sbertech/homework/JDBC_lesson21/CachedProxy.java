package ru.sbertech.homework.JDBC_lesson21;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.concurrent.ConcurrentHashMap;

public class CachedProxy {
    private static final class Args {
        private final Method method;
        private final Object[] args;
        private final int hash;

        public Args(final Method method, final Object[] args) {
            this.method = method;
            this.args = args;
            this.hash = calcHash();
        }

        @Override
        public boolean equals(final Object obj) {
            final Args other = (Args) obj;
            if (!method.equals(other.method)) {
                return false;
            }
            for (int i = 0; i < args.length; ++i) {
                Object o1 = args[i];
                Object o2 = other.args[i];
                if (!(o1 == null ? o2 == null : o1.equals(o2))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return hash;
        }

        private int calcHash() {
            int h = method.hashCode();
            for (final Object o : args) {
                h = h + (o == null ? 0 : o.hashCode());
            }
            return h;
        }
    }

    private static final String URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String LOGIN = "sa";
    private static final String PASSWORD = "";
    private static final String TABLE_NAME = "CACHE";

    private static boolean checkTable() {
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet res = meta.getTables(null, null, TABLE_NAME, null);
            if (res.next())
                result = true;
            res.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static void createTable() {
        try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = conn.prepareStatement("create table " + TABLE_NAME + " (a INTEGER, b INTEGER, sum INTEGER, PRIMARY KEY (a, b))");
            preparedStatement.execute();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void setCacheDataBase(int a, int b, int sum){
        try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement  preparedStatement = conn.prepareStatement("insert into " + TABLE_NAME + " values(?, ?, ?)");
            preparedStatement.setInt(1, a);
            preparedStatement.setInt(2, b);
            preparedStatement.setInt(3, sum);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static <T> T create(final Class<T> cl, final T code) {
        final ConcurrentHashMap<Args, Object> argsToOutput = new ConcurrentHashMap<Args, Object>();
        if (!checkTable())
            createTable();


        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[] { cl }, new InvocationHandler() {

            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                final Args input = new Args(method, args);
                Object result = argsToOutput.get(input);
                if (result == null && !argsToOutput.containsKey(input)) {
                    if ("calculate".equals(method.getName()) && args.length == 2) {
                        int a = (Integer) args[0];
                        int b = (Integer) args[1];
                        try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
                            PreparedStatement preparedStatement = conn.prepareStatement("select * from " + TABLE_NAME + " where a = ? and b = ?");
                            preparedStatement.setInt(1, a);
                            preparedStatement.setInt(2, b);
                            ResultSet resultSet = preparedStatement.executeQuery();
                            if (resultSet.next()) {
                                System.out.println("cach from database: ");
                                result = resultSet.getInt("sum");
                            } else {
                                result = method.invoke(code, args);
                                setCacheDataBase(a, b, (Integer) result);
                            }
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        result = method.invoke(code, args);
                    }
                    argsToOutput.put(input, result);
                }
                else
                    System.out.println("cach: ");
                return result;
            }
        });
    }
}
