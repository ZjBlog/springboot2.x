package spring.springboot2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/17 11:51
 * @Description
 */
@Data
@AllArgsConstructor
//不为空的参数 的构造
@RequiredArgsConstructor(staticName = "error")
@Builder
@Accessors(chain = true)
public class ErrorResult implements Serializable {

    private static final long serialVersionUID = 6759996502483780432L;
    private String code;

    @Length
    private String message;
}
