package spring.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ZJ
 * @date : 19-8-9 上午11:08
 */
@Slf4j
@Service
public class ThymeleafServiceImpl implements ThymeleafService {

    public static final String destPath = "/home/zj/zj/html";

    @Autowired
    private TemplateEngine templateEngine;

    public Map<String, Object> loadModel(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "tellsea");
        map.put("age", 20);
        map.put("email", "3210054449@qq.com");
        return map;
    }

    /**
     * 创建html页面
     *
     * @param spuId
     * @throws Exception
     */
    @Override
    public void createHtml(Long spuId) {
        // 上下文
        Context context = new Context();
        context.setVariables(loadModel(spuId));
        // 输出流
        File dest = new File(destPath, spuId + ".html");
        if (dest.exists()) {
            dest.delete();
        }
        try (PrintWriter writer = new PrintWriter(dest, "UTF-8")) {
            // 生成html
            templateEngine.process("id", context, writer);
        } catch (Exception e) {
            log.error("[静态页服务]：生成静态页异常", e);
        }
    }

    @Override
    public void deleteHtml(Long id) {
        // 输出流
        File dest = new File(destPath, id + ".html");
        if (dest.exists()) {
            dest.delete();
        }
    }
}