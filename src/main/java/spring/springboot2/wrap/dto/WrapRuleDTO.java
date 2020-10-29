package spring.springboot2.wrap.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:28
 * @Description
 */
@Data
public class WrapRuleDTO implements Serializable {
    private static final long serialVersionUID = -535958706958146611L;
    private boolean wrap;

    private Map<String, Object> matchRule;

    private Map<String, Object> noMatchRule;
}
