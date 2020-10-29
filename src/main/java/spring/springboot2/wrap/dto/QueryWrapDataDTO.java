package spring.springboot2.wrap.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:26
 * @Description包装数据查询DTO
 */
@Data
public class QueryWrapDataDTO implements Serializable {
    private static final long serialVersionUID = 3467825794904152914L;
    /**
     * 数据类型，必传
     */
    private String dataType;
    /**
     * 记录ID
     */
    private String id;
    /**
     * 查询条件
     */
    private Map<String, Object> conditions = new HashMap<String, Object>();

}
