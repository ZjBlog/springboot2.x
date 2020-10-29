package spring.springboot2.wrap.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:27
 * @Description包装数据记录.
 */
@Data
public class WrapDataDTO implements Serializable {
    private static final long serialVersionUID = -326225769269654244L;
    /**
     * ID标识
     */
    private String id;
    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 数据
     */
    private Map<String, Object> data;

    public <T> T getData(String key) {
        if (data == null) {
            return null;
        }
        return (T) data.get(key);
    }
}
