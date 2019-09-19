package spring.springboot2.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : ZJ
 * @date : 19-9-6 下午2:00
 */
@Slf4j
public class MyFiflter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("自定义Fiflter  pre");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("自定义Fiflter post");
    }
}
