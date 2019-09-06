package spring.springboot2.config;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : ZJ
 * @date : 19-8-7 上午11:17
 */
@EnableConfigurationProperties({WxConfig.class})
@Data
@Configuration
public class WxTest implements InitializingBean, DisposableBean {

    @Autowired
    private WxConfig wxConfig;

    public String get() {
        return this.wxConfig.getAppid();
    }

    public WxTest() {
        super();
        System.out.println("InitOrderBean执行构造方法......");
    }

    @PostConstruct
    public void test() {
        System.out.println("=================PostConstruct");
    }

    @PreDestroy
    public void test1() {
        System.out.println("=================PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitOrderBean执行xml  destory.........");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }
}
