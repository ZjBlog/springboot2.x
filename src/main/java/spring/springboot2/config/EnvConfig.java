package spring.springboot2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author : ZJ
 * @date : 19-8-6 下午5:00
 */

/**
 * debug =true查看
 * 自动配置
 * Positive matches：已经启用的自动配置
 *
 * Negative matches：未启用的自动配置
 */

@Slf4j
public class EnvConfig implements EnvironmentAware {

    private Environment env;


    public String getString(String key) {
        return env.getProperty(key);
    }


    public Long getLongValue(String key) {
        String string = getString(key);
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0L;

    }

    public int getInt(String key) {
        return getLongValue(key).intValue();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
