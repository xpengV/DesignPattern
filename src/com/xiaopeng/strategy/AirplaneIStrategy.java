package com.xiaopeng.strategy;

public class AirplaneIStrategy implements IStrategy {

    @Override
    public void takeTransportation() {
        System.out.println("坐飞机去伦敦");
    }
}
