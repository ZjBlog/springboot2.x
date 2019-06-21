package spring.springboot2.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author : ZJ
 * @date : 19-6-21 上午11:49
 */
@Component
public class RabbitListtener {

    @RabbitListener(queues = "zz")
    public void test(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println(message);

        if ("test".equals(message)) {
            System.out.println("错误的消息");
            try {
                /**
                 * 说明该消息被 nack 后一直重新入队列然后一直重新消费
                 * 消费失败
                 * 是否批量.true:将一次性拒绝所有小于deliveryTag的消息。
                 * 被拒绝的是否重新入队列
                 */
                channel.basicNack(tag, false, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
}
