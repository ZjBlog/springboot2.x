package spring.springboot2.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import spring.springboot2.x.config.CustomizePropertySourceFactory;

@SpringBootApplication
@ImportResource(locations = {"classpath*:spring/spring-*.xml"})
//加载自定义配置文件 并解密
@PropertySource(value = "classpath:important.properties", factory = CustomizePropertySourceFactory.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
