package spring.springboot2.zj;

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

    private final static String EXCEPTION_MSG_KEY = "Exception message : ";

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleValidException(MethodArgumentNotValidException e) {
        //日志记录错误信息
        log.error(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        //将错误信息返回给前台
        return ErrorResult.builder().code("103").message(e.getBindingResult().getFieldError().getDefaultMessage()).build();
    }
}
