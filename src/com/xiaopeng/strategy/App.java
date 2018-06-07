package com.xiaopeng.strategy;

import org.junit.Test;

public class App {

    @Test
    public void test_E001(){
        Context context;

        System.out.println("去地铁站.....");
        context = new Context(new BicycleIStrategy());  //策略1
        context.takeTransportation();

        System.out.println("去机场.....");
        context = new Context(new SubwayIStrategy());   //策略2
        context.takeTransportation();

        System.out.println("去伦敦.....");
        context = new Context(new AirplaneIStrategy());  //策略3
        context.takeTransportation();
    }
}
