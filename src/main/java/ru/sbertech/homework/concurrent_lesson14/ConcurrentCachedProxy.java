package ru.sbertech.homework.concurrent_lesson14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentCachedProxy {

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
            final ConcurrentCachedProxy.Args other = (ConcurrentCachedProxy.Args) obj;
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
        final ConcurrentHashMap<ConcurrentCachedProxy.Args, Object> argsToOutput = new ConcurrentHashMap<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[] { cl }, new InvocationHandler() {
            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                final ConcurrentCachedProxy.Args input = new ConcurrentCachedProxy.Args(method, args);
                Object result = null;
                String s = "Thread " + Thread.currentThread().getId() + ": " + input.mArgs[0] + " + " + input.mArgs[1];
                reentrantReadWriteLock.readLock().lock();
                if (!argsToOutput.containsKey(input)) {
                    // освобождаем блокировку чтения перед блокировкой записи
                    reentrantReadWriteLock.readLock().unlock();
                    reentrantReadWriteLock.writeLock().lock();
                    if (!argsToOutput.containsKey(input)) {
                        try{
                            result = method.invoke(code, args);
                            argsToOutput.put(input, result);
                            s += " = " + result;
                        } catch (InvocationTargetException e) {
                            throw e.getTargetException();
                        }finally {
                            //reentrantReadWriteLock.readLock().lock();
                            reentrantReadWriteLock.writeLock().unlock();
                            //reentrantReadWriteLock.readLock().unlock();
                            System.out.println(s);
                            return result;
                        }
                    }
                    else {
                        // ставим блокировку чтения, прежде чем отпустить блокировку записи
                        reentrantReadWriteLock.readLock().lock();
                        reentrantReadWriteLock.writeLock().unlock();
                        result = argsToOutput.get(input);
                        s += " = " + result + " FROM CACHE";
                    }
                } else {
                    result = argsToOutput.get(input);
                    s += " = " + result + " FROM CACHE";
                }
                System.out.println(s);
                reentrantReadWriteLock.readLock().unlock();

                return result;
            }
        });

//        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[] { cl }, new InvocationHandler() {
//
//            @Override
//            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
//                final ConcurrentCachedProxy.Args input = new ConcurrentCachedProxy.Args(method, args);
//                boolean flag = false;
//                Object result = null;
//                String s = "Thread " + Thread.currentThread().getId() + ": " + input.mArgs[0] + " + " + input.mArgs[1];
//                reentrantReadWriteLock.readLock().lock();
//                if (!argsToOutput.containsKey(input)) {
//                    // освобождаем блокировку чтения перед блокировкой записи
//                    reentrantReadWriteLock.readLock().unlock();
//                    reentrantReadWriteLock.writeLock().lock();
//                    try {
//                        //перепроверяем состояние
//                        if (!argsToOutput.containsKey(input)) {
//                            result = method.invoke(code, args);
//                            argsToOutput.put(input, result);
//                            s += " = " + result;
//                            flag = true;
//                        }
//                        else {
//                            // ставим блокировку чтения, прежде чем отпустить блокировку записи
//                            reentrantReadWriteLock.readLock().lock();
//                            reentrantReadWriteLock.writeLock().unlock();
//                            result = argsToOutput.get(input);
//                            s += " = " + result + " FROM CACHE";
//                            flag = false;
//                        }
//
//                    }  catch (InvocationTargetException e) {
//                        throw e.getTargetException();
//                    }  finally {
//                        if (flag){
//                            reentrantReadWriteLock.readLock().lock();
//                            reentrantReadWriteLock.writeLock().unlock();
//                        }
//                    }
//                } else {
//                    result = argsToOutput.get(input);
//                    s += " = " + result + " FROM CACHE";
//                }
//                reentrantReadWriteLock.readLock().unlock();
//                System.out.println(s);
//                return result;
//            }
//        });
    }
}