package com.xiaopeng.singleton;

/**
 * -------------------------------------------
 *
 * @ClassName:SingletonA
 * @Author xiaopeng
 * @Date 2018/9/19 下午2:09
 * @Version v1.0
 * @Description 饿汉式单例
 * -------------------------------------------
 */
public class SingletonA {

    private SingletonA(){}

    private static final SingletonA instance = new SingletonA();

    public static SingletonA getInstance(){
        return instance;
    }
}
