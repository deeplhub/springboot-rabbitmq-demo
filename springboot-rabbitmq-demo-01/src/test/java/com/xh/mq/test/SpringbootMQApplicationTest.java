package com.xh.mq.test;

import com.xh.mq.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2020/6/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMQApplicationTest {

    @Resource
    private ProducerService producerService;//使用该模板类发送消息

    @Test
    public void sendMessage() {
        //向Queue中发送文本消息
        producerService.sendMessageToQueue("QUEUE消息内容");
    }
}
