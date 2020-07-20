package spring.springboot2.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

/**
 * @author : ZJ
 * @date : 19-9-6 下午2:03
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {


    @Bean
    public MyFiflter myFiflter() {
        return new MyFiflter();
    }

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(myFiflter());
        registrationBean.setEnabled(true);
        return registrationBean;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
    }

    /**
     * 接收Request Body中JSON或XML对象参数
     * 在这里，Spring MVC 是使用 Jackson 对参数进行反序列化，所以对于 String 的处理是
     *
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> {
            // 为 String 类型自定义反序列化操作
            jacksonObjectMapperBuilder
                    .deserializerByType(String.class, new StdScalarDeserializer<String>(String.class) {
                        private static final long serialVersionUID = -444704252376778404L;

                        @Override
                        public String deserialize(JsonParser jsonParser, DeserializationContext ctx)
                                throws IOException {
                            // 去除前后空格
                            return org.apache.commons.lang.StringUtils.isBlank(StringUtils.trimWhitespace(jsonParser.getValueAsString()))
                                    ? null : StringUtils.trimWhitespace(jsonParser.getValueAsString());
                        }
                    });
        };
    }
}
