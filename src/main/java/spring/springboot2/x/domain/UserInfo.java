package spring.springboot2.x.domain;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/8/11 10:02
 * @Description
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 3528455985789377369L;
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
