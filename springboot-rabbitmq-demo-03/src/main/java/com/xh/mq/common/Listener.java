package com.xh.mq.common;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Title: 消费者监听
 * Description:
 *
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2020/6/9
 */
@Component
@RabbitListener(queues = "rabbitmq.topic.queue.msg1")
public class Listener {

    @RabbitHandler
    public void consumeQueue1(String msg) {
        System.out.println("queue_msg 1获得的消息是：" + msg);
    }

}
