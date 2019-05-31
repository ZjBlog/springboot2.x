package spring.springboot2.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * @author : ZJ
 * @date : 19-5-31 下午5:29
 */
@Component
@Slf4j
public class RabbitSender implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMsg(String content) {

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        /**
         * rabbitTemplate如果为单例的话，那回调就是最后设置的内容
         */
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.convertAndSend("test",
                "zzz", content, correlationId);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info(" 回调id:" + correlationData);
        if (b) {
            log.info("消息成功消费");
        } else {
            log.error("消息消费失败:" + s);
        }

    }

    @RabbitListener(queues = "zz")
   // @RabbitHandler
    public void  test(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println(message);

        if("ddd".equals(message)){
            System.out.println("错误的消息");
            try {
                /**
                 * 说明该消息被 nack 后一直重新入队列然后一直重新消费
                 * 消费失败
                 */
                channel.basicNack(tag,false,true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * 确认消费成功
         */
        try {
            channel.basicAck(tag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 拒绝该消息，消息会被丢弃，不会重回队列
         */
        try {
            channel.basicReject(tag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
