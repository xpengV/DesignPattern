package com.xiaopeng.strategy;

public class SubwayIStrategy implements IStrategy {

    @Override
    public void takeTransportation() {
        System.out.println("坐地铁去机场");
    }
}
