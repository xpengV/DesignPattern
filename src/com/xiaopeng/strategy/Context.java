package com.xiaopeng.strategy;

public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void takeTransportation(){
        this.strategy.takeTransportation();  //调用策略算法
    }
}
