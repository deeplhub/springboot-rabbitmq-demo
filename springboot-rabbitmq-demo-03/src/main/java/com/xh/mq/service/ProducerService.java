package com.xh.mq.service;

/**
 * Title: 消息提供者接口
 * Description:
 *
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2020/6/9
 */
public interface ProducerService {

    void sendMessageToQueue(Object message);
}
