package spring.springboot2.entity;

import lombok.Data;
import spring.springboot2.Until.EnumValid;

import javax.validation.constraints.NotBlank;
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

    @Size(max = 4)
    @NotNull(message = "公司类型不能为空")
    private String companyType;

    @NotBlank(message = "公司名字不能为空")
    private String name;
    @NotBlank(message = "枚举名字不能为空")
    @EnumValid(enumClass = TestEnum.class)
    private String enumType;

}