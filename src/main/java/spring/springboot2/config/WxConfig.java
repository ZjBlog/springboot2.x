package spring.springboot2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : ZJ
 * @date : 19-8-7 上午11:13
 */
@ConfigurationProperties(prefix = "wx")
public class WxConfig {
    private String appid;
    private String key;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
