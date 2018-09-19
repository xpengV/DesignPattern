//package com.xiaopeng.strategy.upper;
//
//import com.accounting.dokafka.json.strategy.IJsonParseByTopic;
//import com.accounting.dokafka.json.strategy.TopicName;
//import com.dcits.galaxy.base.util.ExceptionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.FileFilter;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Method;
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author xiaopeng
// * @create 2018-8-30
// * @description kafka消息处理策略工厂，选取topic对应的消息处理类
// */
//public class JsonPraseFactory {
//
//    private static final Logger logger = LoggerFactory.getLogger(JsonPraseFactory.class);       //logger
//
//    private boolean bFlag = false;  //使用单例
//
//    private static final String JSON_PRASE_PACKAGE = "com.accounting.dokafka.json.strategy";    //常量，配置策略所在包
//
//    private ClassLoader classLoader = getClass().getClassLoader();                              //类加载器
//
//    private static List<Class<? extends IJsonParseByTopic>> praseByTopicList;                   //策略列表
//
//    //public static List<Map<String , List<String>>> mapperList;
//
//    private static JsonPraseFactory singleton;                                         //单例类 ， 确保topic与获取的处理类是一致的
//
//    private JsonPraseFactory() {
//        init();
//    }
//
//    //工厂类初始化时创建策略类列表
//    private void init() {
//        praseByTopicList = new ArrayList<Class<? extends IJsonParseByTopic>>();
//        File[] resources = getResources();//获取到包下所有的class文件
//        Class<IJsonParseByTopic> iJsonParseByTopicClass = null;
//        try {
//            iJsonParseByTopicClass = (Class<IJsonParseByTopic>) classLoader.loadClass(IJsonParseByTopic.class.getName());//使用相同的加载器加载策略接口
//        } catch (ClassNotFoundException e1) {
//            throw new RuntimeException("未找到策略类");
//        }
//        for (int i = 0; i < resources.length; i++) {
//            try {
//                //载入包下的类
//                Class<?> clazz = classLoader.loadClass(JSON_PRASE_PACKAGE + "." + resources[i].getName().replace(".class", ""));
//                //判断是否是IJsonParseByTopic的实现类并且不是IJsonParseByTopic它本身，满足的话加入到策略列表
//                if (IJsonParseByTopic.class.isAssignableFrom(clazz) && clazz != iJsonParseByTopicClass) {
//                    praseByTopicList.add((Class<? extends IJsonParseByTopic>) clazz);
//                }
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException("没有找到topic对应的处理类\r\n" + e);
//            }
//        }
//
//        logger.debug("策略实现类列表：" + praseByTopicList);
//    }
//
//    /**
//     * 获取扫描的包下面所有的class文件--返回策略列表
//     */
//    private File[] getResources() {
//        try {
//            File file = new File(classLoader.getResource(JSON_PRASE_PACKAGE.replace(".", "/")).toURI());
//            return file.listFiles(new FileFilter() {
//                public boolean accept(File pathname) {
//                    if (pathname.getName().endsWith(".class")) {    //扫描包下的class文件
//                        return true;
//                    }
//                    return false;
//                }
//            });
//        } catch (URISyntaxException e) {
//            logger.error("未找到策略资源：" + ExceptionUtils.getStackTrace(e));
//            return null;
//        }
//    }
//
//
//    /**
//     * 根据topic策略类的注解以及消息队列中消息的topic获取特定的处理类
//     *
//     * @param assemble
//     * @return
//     */
//    public synchronized IJsonParseByTopic getJsonPraseMethod(KafkaMessageAssemble assemble) {
//
//
//        //在策略列表查找策略
//        for (Class<? extends IJsonParseByTopic> clazz : praseByTopicList) {
//
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                logger.error("策略获取失败sleep" + ExceptionUtils.getStackTrace(e));
//            }
//
//            TopicName topicName = handleAnnotation(clazz);                   //获取该策略的注解
//
//            if (assemble.getTopicName() == topicName.topic() || assemble.getTopicName().equals(topicName.topic())) {
//                try {
//                    logger.debug("针对topic[" + assemble.getTopicName() + "],选取的处理类是[" + clazz.getName() + "]");
//                    //return clazz.newInstance();
//                    /*
//                     * modify by xiaopengb 2018/9/5 18:42 for
//                     * 不使用clazz.newInstance()创建实例，这样每次处理消息就会实例化一个策略
//                     * 使用反射调用getInstance的方法，达到策略都是单例的目的
//                     */
//
//                    if (bFlag) {
//                        logger.debug("针对topic[" + assemble.getTopicName() + "],选取的处理类是[" + clazz.getName() + "]");
//                        return clazz.newInstance();
//                    } else {
//                        Method m = clazz.getDeclaredMethod("getInstance");  //getInstance() 策略类都应该有该方法
//                        Object obj = m.invoke(clazz);
//                        logger.debug("针对topic[" + assemble.getTopicName() + "],选取的处理类是[" + clazz.getName() + "],反射得到的clazz=[" + obj + "]");
//                        return (IJsonParseByTopic) obj;
//                    }
//
//                } catch (Exception e) {
//                    logger.error("策略获取失败" + ExceptionUtils.getStackTrace(e));
//                }
//            }
//        }
//        throw new RuntimeException("JsonPraseFactory.getJsonPraseMethod()最终无法获取topic处理策略");
//    }
//
//    private TopicName handleAnnotation(Class<? extends IJsonParseByTopic> clazz) {
//
//        Annotation[] annotations = clazz.getDeclaredAnnotations();
//        if (annotations == null || annotations.length == 0) {
//            return null;
//        }
//        for (int i = 0; i < annotations.length; i++) {
//            if (annotations[i] instanceof TopicName) {
//                return (TopicName) annotations[i];
//            }
//        }
//        return null;
//    }
//
//    public static JsonPraseFactory getInstance() {
//        if (singleton == null) {
//                singleton = new JsonPraseFactory();
//        }
//
//        logger.debug("策略工厂[" + singleton + "]");
//        return singleton;
//    }
//}
