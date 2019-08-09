package spring.springboot2.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : ZJ
 * @date : 19-8-7 上午11:17
 */
@EnableConfigurationProperties({WxConfig.class})
@Data
@Configuration
public class WxTest {

    @Autowired
    private WxConfig wxConfig;

    public String get(){
        return  this.wxConfig.getAppid();
    }
}
