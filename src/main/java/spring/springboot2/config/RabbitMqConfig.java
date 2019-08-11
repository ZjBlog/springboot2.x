//package spring.springboot2.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.SerializerMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
///**
// * @author : ZJ
// * @date : 19-5-31 下午5:10
// */
//@Configuration
//public class RabbitMqConfig {
//
//    /**
//     * 直连交换机
//     *
//     * @return
//     */
//    @Bean
//    public TopicExchange defaultExchange() {
//        return new TopicExchange("test");
//    }
//
//    /**
//     * 队列
//     *
//     * @return
//     */
//    @Bean
//    public Queue queue() {
//        return new Queue("zz", true);
//    }
//
//    /**
//     * 绑定
//     *
//     * @return
//     */
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(this.queue()).to(this.defaultExchange()).with("zzz");
//    }
//
//
//    /**
//     * Only one ConfirmCallback is supported by each RabbitTemplate  解决这个问题
//     * @param connectionFactory
//     * @return
//     */
//    /**
//     * @Scope(“prototype”) 改变为多例（默认为单例Singleton）
//     * request session global session
//     * @param connectionFactory
//     * @return
//     */
//    @Bean
//    @Scope("prototype")
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        return template;
//    }
//}
