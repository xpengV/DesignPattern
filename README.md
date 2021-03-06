# 1、设计模式的原则
开闭原则：对扩展开放，对修改关闭。在程序做拓展时，不能修改原有的代码，而是进行功能的拓展，实现一个热插拔的效果。即就是易于升级和维护。

1. 单一职责原则
不要存在多于一个导致类变更的原因，也就是每一类实现单一的职责，否则就应该把类拆分。
2. 里氏替换原则
任何基类可以出现的地方，子类一定也可以出现。这是继承复用的基石，只有当衍生类可以替换基类，软件功能不受影响时，基类才可以真正的被复用，而衍生类也可以增加新的功能。
3. 依赖倒转原则
面向接口编程，依赖于抽象而不是具体。当编写代码用到具体的类时，不与之交互而是与类的抽象接口交互。
4. 接口隔离原则
接口中不存在实现类不需要的方法，否则要将接口拆分。
5. 迪米特法则
一个类将自身的依赖暴露的越少越好，无论内部依赖多么复杂，都应该将逻辑封装在方法内部，并通过*public*方法提供给外部使用。
6. 合成复用原则
尽量使用合成/聚合的方式，而不是使用继承（单继承的体系关系）

# 2、设计模式的分类
1. 创建型模式
- [工厂方法模式](https://xpengv.github.io/2017/07/02/工厂模式/)
- [抽象工厂模式](https://xpengv.github.io/2017/07/02/工厂模式/)
- [单例模式](https://xpengv.github.io/2017/06/03/单例模式/)
- [建造者模式]()
- [原型模式]()

2. 结构型模式
- [适配器模式]()
- [装饰者模式](https://xpengv.github.io/2017/03/26/装饰者模式/)
- [代理模式](https://xpengv.github.io/2017/04/05/Java代理/)
- [外观模式]()
- [桥接模式]()
- [组合模式]()
- [亨元模式]()

3. 行为型模式
- [策略模式](https://xpengv.github.io/2017/05/23/策略模式/)
- [模板方法模式]()
- [观察者模式](https://xpengv.github.io/2017/07/07/观察者模式/)
- [迭代子模式]()
- [责任链模式]()
- [命令模式]()
- [备忘录模式]()
- [状态模式]()
- [访问者模式]()
- [中介者模式]()
- [解释器模式]()


# 3、tips
我的设计模式[www.xiaopeng.pro](http://www.xiaopeng.pro)
