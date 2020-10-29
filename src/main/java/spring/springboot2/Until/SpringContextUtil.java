package spring.springboot2.Until;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * SpringContextUtil
 *
 * @author Administrator
 */
@Component
@Lazy(false)
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getCtx() {
        return SpringContextUtil.applicationContext;
    }

    public static <T> T getBean(Class<T> t) {
        return SpringContextUtil.applicationContext.getBean(t);
    }

    //返回 beanname    类
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return SpringContextUtil.applicationContext.getBeansOfType(clazz);
    }

}
