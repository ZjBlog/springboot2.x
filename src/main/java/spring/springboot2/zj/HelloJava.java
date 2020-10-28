package spring.springboot2.zj;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.Until.CacheService;
import spring.springboot2.entity.TetsDto;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/17 10:49
 * @Description
 */
@RestController
@RequestMapping("/java")
public class HelloJava {

    @Autowired
    private CacheService cacheService;

    /**
     * 接收 url 或 form 表单中的参数
     * "" 替换成空格
     * 如果是@RequestBody 接收参数 需自定义
     * Jackson2ObjectMapperBuilderCustomizer
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @PostMapping("/test2")
    public String HellorWorld4(@RequestBody TetsDto testDto) {
        System.out.println(testDto.toString());
        return "ok";
    }

    @PostMapping("/test")
    public String HellorWorld2(@Valid @RequestBody TetsDto testDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            //所有的错误信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getDefaultMessage());
            }
            //第一个
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "ok";
    }

    /**
     * 验证错误全局处理
     *
     * @param testDto
     * @return
     */
    @PostMapping("/test1")
    public String HellorWorld3(@Valid @RequestBody TetsDto testDto) throws ExecutionException {

        String kkk = cacheService.productCache.get("kkk");
        System.out.println(kkk);

        String unchecked = cacheService.productCache.getUnchecked("888");
        System.out.println(unchecked);
        return "ok";
    }

    @GetMapping("/test5")
    public String HellorWorld5(@RequestParam(name = "code") String code) {
        if (StringUtils.isBlank(code)) {
            throw new NullPointerException("code is null");
        }
        return "ok";
    }
}
