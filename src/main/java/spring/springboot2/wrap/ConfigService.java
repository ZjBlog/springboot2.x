package spring.springboot2.wrap;

import org.springframework.stereotype.Component;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:30
 * @Description全局开关数据、规则数据、MOCK数据集均存储在config表中 ConfigService获取
 */
@Component
public class ConfigService {

    public String getConfigValue(String key) {
        //TODO 从数据库或配置文件中获取
        return "false";
    }
}
