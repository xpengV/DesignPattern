package com.xiaopeng.strategy;

import org.junit.Test;


public class App {

    /**
     * 考虑到test_E001()类似的写法会出现if--else---的判断（在不同的情况下使用不同的策略），但是这样会有严重的耦合度。
     *
     * 建议使用在策略实现类上加入自定义注解信息，然后在客户端匹配注解。
     * 详见com.xiaopeng.strategy.upper.JsonPraseFactory.java
     */
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
