package spring.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author : ZJ
 * @date : 19-5-31 下午5:29
 */
@Component
@Slf4j
public class RabbitSender1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMsg(String content) {

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        /**
         * rabbitTemplate如果为单例的话，那回调就是最后设置的内容
         */


        rabbitTemplate.setMandatory(true);
        /**
         * 消息到了broker
         */
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
            log.info(" 回调id:" + correlationData);
            if (ack) {
                log.info("消息成功消费");
            } else {
                log.error("消息消费失败:" + cause);
            }
        });
        /**
         * broker 接收到只能表示 message 已经到达服务器，并不能保证消息一定会被投递到目标 queue 里
         * 失败返回
         */
        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText,
                String exchange, String routingKey)->{
            System.out.println("消息主体 message : "+message);
            System.out.println("消息主体 message : "+replyCode);
            System.out.println("描述："+replyText);
            System.out.println("消息使用的交换器 exchange : "+exchange);
            System.out.println("消息使用的路由键 routing : "+routingKey);
        });
        rabbitTemplate.convertAndSend("test",
                "zzz", content, correlationId);
    }


}
