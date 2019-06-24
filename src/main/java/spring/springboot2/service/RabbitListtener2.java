package spring.springboot2.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import spring.springboot2.entity.UserBot;

import java.io.IOException;

/**
 * @author : ZJ
 * @date : 19-6-21 下午1:32
 */

/**
 * @RabbitListener可以用在方法及类上
 * 如果放在类上需要和@RabbitHandler 配合使用  根据 内容类型 去走那个方法处理
 */
@Component
@RabbitListener(queues = "zz")
public class RabbitListtener2 {

    /**
     * userBot类型走这个
     * @param userBot
     * @param channel
     * @param tag
     */
    @RabbitHandler
    public void test(UserBot userBot, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println(userBot.toString());
        /**
         * 确认消费成功
         */
        try {
            channel.basicAck(tag, false);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 拒绝该消息，消息会被丢弃，不会重回队列
         * 不能重复使用一个tag否则会reply-code=406, reply-text=PRECONDITION_FAILED - unknown delivery tag 1, class-id=60, method-id=80
         * 出错
         */
        try {
            channel.basicReject(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * string 类型走这个
     * @param userBot
     * @param channel
     * @param tag
     */
    @RabbitHandler
    public void test(String userBot, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println(userBot);
        System.out.println("String");
        /**
         * 拒绝该消息，消息会被丢弃，不会重回队列
         * 不能重复使用一个tag否则会reply-code=406, reply-text=PRECONDITION_FAILED - unknown delivery tag 1, class-id=60, method-id=80
         * 出错
         */
        try {
            channel.basicReject(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
