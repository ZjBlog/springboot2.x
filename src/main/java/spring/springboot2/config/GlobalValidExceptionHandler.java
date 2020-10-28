package spring.springboot2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.springboot2.entity.ErrorResult;

import java.util.Objects;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/17 11:49
 * @Description
 * @Valid注解异常捕获
 */
@Slf4j
@ControllerAdvice
public class GlobalValidExceptionHandler {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorResult handleValidException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            //日志记录错误信息
            log.error(Objects.requireNonNull(methodArgumentNotValidException.getBindingResult().getFieldError()).getDefaultMessage());
            //将错误信息返回给前台
            return ErrorResult.builder().code("103").message(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage()).build();
        } else {
            return ErrorResult.builder().code("103").message("系统异常,请稍后重试").build();
        }
    }
}
