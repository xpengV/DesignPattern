package com.xiaopeng.observer;

import org.junit.Test;

public class App {

    @Test
    public void test_E001(){

        WeChatServer server = new WeChatServer();
        Observer o1 = new User("user1");
        Observer o2 = new User("user2");
        Observer o3 = new User("user3");

        server.registerObserver(o1);
        server.registerObserver(o2);
        server.registerObserver(o3);

        System.out.println("-------------已经注册的观察者-------------");
        for(int i=0 ;i < WeChatServer.list.size();i++){
            System.out.println(WeChatServer.list.get(i));
        }

        server.setInfomation("l love programming！");
    }
}
