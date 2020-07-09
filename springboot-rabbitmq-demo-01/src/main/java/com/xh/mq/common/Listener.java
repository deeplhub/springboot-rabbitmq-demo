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
@RabbitListener(queues = "rabbitmq.direct.queue.msg")
public class Listener {

//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value = @Queue(value = "rabbitmq.direct.queue.msg", durable = "false"),
//                    exchange = @Exchange(value = "rabbitmq.direct.exchange.queue"),
//                    key = "rabbitmq.direct.routing.queue"
//            )
//    })
//    @RabbitHandler
//    @RabbitListener(queues = "rabbitmq.direct.routing.queue")
    @RabbitHandler
    public void consumeQueue1(String msg) {
        System.out.println("queue_msg 1获得的消息是：" + msg);
    }

}
