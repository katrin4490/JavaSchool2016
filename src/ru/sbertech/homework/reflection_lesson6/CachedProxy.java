package ru.sbertech.homework.reflection_lesson6;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


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
        final Map<Args, Object> argsToOutput = new HashMap<Args, Object>();

        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[] { cl }, new InvocationHandler() {

            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                final Args input = new Args(method, args);
                Object result = argsToOutput.get(input);
                if (result == null && !argsToOutput.containsKey(input)) {
                    try {
                        result = method.invoke(code, args);
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
