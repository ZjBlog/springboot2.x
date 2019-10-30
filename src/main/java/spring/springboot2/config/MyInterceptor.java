package spring.springboot2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author : ZJ
 * @date : 19-9-6 下午2:27
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("============我的拦截器pre");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod myHandlerMethod = (HandlerMethod) handler;
        Method method = myHandlerMethod.getMethod();
        Object bean = myHandlerMethod.getBean();
        //方法上有该标记
        Auth annotation = method.getAnnotation(Auth.class);
        if (annotation == null) {
            //类上有该标记
            annotation = bean.getClass().getAnnotation(Auth.class);
        }

        log.info(annotation.name());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("============我的拦截器post");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("============我的拦截器after");
    }
}
