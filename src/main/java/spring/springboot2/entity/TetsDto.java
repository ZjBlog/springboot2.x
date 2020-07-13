package spring.springboot2.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/7 15:25
 * @Description
 */
@Data
public class TetsDto implements Serializable {

    private static final long serialVersionUID = 7168145817103794957L;


    @NotNull(message = "不能为空")
    @Size(max = 4)
    private String companyType_type;

}
