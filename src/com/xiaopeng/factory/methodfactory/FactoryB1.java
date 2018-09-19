package com.xiaopeng.factory.methodfactory;

/**
 * -------------------------------------------
 *
 * @ClassName:FactoryA
 * @Author xiaopeng
 * @Date 2018/9/19 下午3:19
 * @Version v1.0
 * @Description TODO
 * -------------------------------------------
 */
public abstract class FactoryB1 extends FactoryB{

    @Override
    public Product createProduct() {
        return new ProductB1();
    }
}
