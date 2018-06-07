package com.xiaopeng.strategy;

public class BicycleIStrategy implements IStrategy {

    @Override
    public void takeTransportation() {
        System.out.println("骑单车去地铁站");
    }
}
