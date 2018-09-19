package com.xiaopeng.singleton;

/**
 * -------------------------------------------
 *
 * @ClassName:Singleton
 * @Author xiaopeng
 * @Date 2018/9/19 下午1:48
 * @Version v1.0
 * @Description 懒汉式单例
 * -------------------------------------------
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static synchronized Singleton getInstance_1() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstance_2() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return null;
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance_3() {
        return LazyHolder.INSTANCE;
    }
}

