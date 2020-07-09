package com.xh.mq.common;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: 广播模式
 * Description:
 *
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2020/6/22
 */
@Configuration
public class TopicRabbitConfig {

    public static final String TOPIC_QUEUE_NAME1 = "rabbitmq.topic.queue.msg1";
    public static final String TOPIC_QUEUE_NAME2 = "rabbitmq.topic.queue.msg2";
    public static final String TOPIC_EXCHANGE = "rabbitmq.topic.exchange";
    public static final String TOPIC_ROUTINGKEY = "rabbitmq.topic.#";

    //创建队列
    @Bean
    public Queue getTopicQueue1() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("TestDirectQueue",true,true,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue(TOPIC_QUEUE_NAME1);
    }
    //创建队列
    @Bean
    public Queue getTopicQueue2() {
        return new Queue(TOPIC_QUEUE_NAME2);
    }

    //创建交换机
    @Bean
    public TopicExchange topicExchange() {
//        return ExchangeBuilder.directExchange(DIRECT_EXCHANGE).durable(false).build();
        // 等同
        return new TopicExchange(TOPIC_EXCHANGE, false, false);
    }

    //将队列和交换机绑定，并设置用于匹配键
    @Bean
    public Binding bindingTopic1(Queue getTopicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(getTopicQueue1).to(topicExchange).with(TOPIC_ROUTINGKEY);
    }
    @Bean
    public Binding bindingTopic2(Queue getTopicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(getTopicQueue2).to(topicExchange).with(TOPIC_ROUTINGKEY);
    }
}
