package com.xh.mq.service.impl;

import com.xh.mq.common.TopicRabbitConfig;
import com.xh.mq.service.ProducerService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: 消息提供者
 * Description:
 *
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2020/6/9
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void sendMessageToQueue(Object message) {
//        rabbitTemplate.convertAndSend(exchange, routingKey, message);
//        rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGE, FanoutRabbitConfig.FANOUT_QUEUE_NAME1, message);
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, TopicRabbitConfig.TOPIC_ROUTINGKEY, message);
    }
}
