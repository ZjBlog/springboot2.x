package spring.springboot2.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author : ZJ
 * @date : 19-5-31 下午5:10
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 直连交换机
     *
     * @return
     */
    @Bean
    public TopicExchange defaultExchange() {
        return new TopicExchange("test");
    }

    /**
     * 队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("zz", true);
    }

    /**
     * 绑定
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(this.queue()).to(this.defaultExchange()).with("zzz");
    }
}
