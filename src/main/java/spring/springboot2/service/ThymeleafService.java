package spring.springboot2.service;

import org.springframework.web.bind.annotation.RequestParam;
import spring.springboot2.config.TestAuth;

/**
 * @author : ZJ
 * @date : 19-8-9 上午11:08
 */
public interface ThymeleafService {
    void createHtml(Long id);

    void deleteHtml(Long id);
//不行的
    //@TestAuth(value = "#name")
    String test(String name);
}
