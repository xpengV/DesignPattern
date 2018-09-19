//package com.xiaopeng.strategy.upper;
//
//import com.accounting.dokafka.json.strategy.IJsonParseByTopic;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * 根据topic选取对应的IJsonParseByTopic , 并调用对应策略类的对应处理方法
// */
//public class KafkaMessageAssemble {
//
//    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageAssemble.class);      //logger
//
//    public IJsonParseByTopic iJsonParseByTopic = null;
//
//    private static String topicName;  //kafka-topic
//
//    private static volatile KafkaMessageAssemble singleton;
//
//    public String getTopicName() {
//        return topicName;
//    }
//
//    public KafkaMessageAssemble(String _topicName) {
//        this.topicName = _topicName;
//    }
//
//    //单例
//    public static KafkaMessageAssemble getInstance(String _topicName) {
//        if (singleton == null) {
//            synchronized (KafkaMessageAssemble.class) {
//                singleton = new KafkaMessageAssemble(_topicName);
//            }
//        }
//        return singleton;
//    }
//
//    /*
//    public void chooseByTopic(String topicName){
//
//        if("MB_TRAN_HIST".equals(topicName)){
//            iJsonParseByTopic = new MbMiscHistTopic();
//        }else if("MB_MISC_HIST".equals(topicName)){
//            iJsonParseByTopic = new MbMiscHistTopic();
//        }
//    }
//    */
//
//    /**
//     * 获取客户端topic对应的处理策略类，[解耦]
//     */
//    public synchronized void chooseByTopicUpper() {
//        iJsonParseByTopic = JsonPraseFactory.getInstance().getJsonPraseMethod(this);  //根据客户端确定策略
//        logger.debug("消息处理类：[" + iJsonParseByTopic + "]");
//    }
//
//    /**
//     * 处理kafka消息队列中取出的消息（string类型)
//     *
//     * @param kafkaMessage
//     * @return
//     */
//    public void jsonPraseByTopic(String kafkaMessage) {
//        iJsonParseByTopic.jsonPraseByTopic(kafkaMessage);
//    }
//
//}
