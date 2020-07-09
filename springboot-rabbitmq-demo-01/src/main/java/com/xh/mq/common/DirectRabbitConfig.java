package com.xh.mq.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: 直连模式
 * Description:
 *
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2020/6/22
 */
@Configuration
public class DirectRabbitConfig {
    Logger log = LoggerFactory.getLogger(DirectRabbitConfig.class);

    public static final String DIRECT_QUEUE_NAME = "rabbitmq.direct.queue.msg";
    public static final String DIRECT_EXCHANGE = "rabbitmq.direct.exchange";
    public static final String DIRECT_ROUTINGKEY = "rabbitmq.direct.routing";

    //创建队列
    @Bean
    public Queue getDirectQueue() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("TestDirectQueue",true,true,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue(DIRECT_QUEUE_NAME);
    }

    //创建交换机
    @Bean
    public DirectExchange directExchange() {
//        return ExchangeBuilder.directExchange(DIRECT_EXCHANGE).durable(false).build();
        // 等同
        return new DirectExchange(DIRECT_EXCHANGE, false, false);
    }

    //将队列和交换机绑定，并设置用于匹配键
    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(getDirectQueue()).to(directExchange()).with(DIRECT_ROUTINGKEY);
    }

}
