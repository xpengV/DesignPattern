package com.xiaopeng.observer;

/**
 * @author xiaopeng
 * 当被观察者发生变化时，观察者会自动调用update方法
 */
public interface Observer {

    public void update(String message);
}
