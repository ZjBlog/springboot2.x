package spring.springboot2.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.PropertyResolver;

/**
 * @author : ZJ
 * @date : 19-8-6 下午5:05
 * 注册到ioc容器
 */
@Configuration
@ConditionalOnClass(PropertyResolver.class)
public class EnvAutoConfig {


    @Bean
    public EnvConfig envConfig() {
        return new EnvConfig();
    }


    @Order(3)
    @Bean
    public CommandLineRunner init() {
        return (String... strings) -> {
            System.out.println("=====================");
        };
    }

    @Order(4)
    @Bean
    public CommandLineRunner init3() {
        return (String... strings) -> {
            System.out.println("======333333===============");
        };
    }


    @Bean
    public ApplicationRunner INIT2() {
        return (ApplicationArguments args) -> {
            System.out.println("====================222222222222");
        };
    }
}
