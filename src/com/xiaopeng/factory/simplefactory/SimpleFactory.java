package com.xiaopeng.factory.simplefactory;

/**
 * -------------------------------------------
 *
 * @ClassName:SimpleFactory
 * @Author xiaopeng
 * @Date 2018/9/19 下午2:48
 * @Version v1.0
 * @Description TODO
 * -------------------------------------------
 */
public class SimpleFactory {

    public Computer createComputer(int type) {
        switch (type) {
            case 450:
                return new ThinkPad_E450();
            case 460:
                return new ThinkPad_E460();
            default:
                break;
        }
        return null;
    }
}
