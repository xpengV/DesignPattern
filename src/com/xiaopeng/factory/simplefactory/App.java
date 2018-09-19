package com.xiaopeng.factory.simplefactory;

/**
 * -------------------------------------------
 *
 * @ClassName:App
 * @Author xiaopeng
 * @Date 2018/9/19 下午2:50
 * @Version v1.0
 * @Description TODO
 * -------------------------------------------
 */
public class App {
    public static void main(String[] args){
        SimpleFactory factory = new SimpleFactory();
        factory.createComputer(450);
    }
}
