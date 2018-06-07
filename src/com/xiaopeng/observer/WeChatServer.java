package com.xiaopeng.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaopeng
 */
public class WeChatServer implements Observerable{

    public static List<Observer> list;  //该list保存所有注册的观察者，用来通知
    private String message;

    public WeChatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

        if(!list.isEmpty())
            list.remove(o);
    }

    @Override
    public void notifyObserver() {

        for(int i = 0;i<list.size();i++){
            list.get(i).update(message);  //观察者调用自身方法
        }
    }

    public void setInfomation(String _message){
        this.message = _message;
        System.out.println("WeChatServer 更新消息：" + _message);

        //通知
        notifyObserver();
    }
}
