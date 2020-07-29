package spring.springboot2.x.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.util.StringUtils;
import spring.springboot2.x.until.AesUtil;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/29 16:52
 * @Description 加载自定义配置文件
 */
public class CustomizePropertySourceFactory implements PropertySourceFactory {
    private static final Logger LOGGER = Logger.getLogger(CustomizePropertySourceFactory.class.getName());

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        if (name == null) {
            name = getNameForResource(resource.getResource());
        }
        String filename = resource.getResource().getFilename();
        Properties props;
        if (filename != null && (filename.endsWith(".yml") || filename.endsWith(".yaml"))) {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(resource.getResource());
            factory.afterPropertiesSet();
            props = factory.getObject();
        } else {
            props = new Properties();
            PropertiesLoaderUtils.fillProperties(props, resource);
        }
        AesUtil.decrypt(props);
        return new PropertiesPropertySource(name, props);
    }

    private String getNameForResource(Resource resource) {
        String name = resource.getDescription();
        if (!StringUtils.hasText(name)) {
            name = resource.getClass().getSimpleName() + "@" + System.identityHashCode(resource);
        }
        return name;
    }
}
