package spring.springboot2.zj;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.entity.TetsDto;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/17 10:49
 * @Description
 */
@RestController
@RequestMapping("/java")
public class HelloJava {

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
    public String HellorWorld3(@Valid @RequestBody TetsDto testDto) {
        return "ok";
    }
}
