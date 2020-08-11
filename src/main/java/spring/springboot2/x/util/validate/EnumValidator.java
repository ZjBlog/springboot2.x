package spring.springboot2.x.util.validate;


import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/30 15:47
 * @Description 枚举校验器
 */
public class EnumValidator implements ConstraintValidator<EnumValid, String> {

    private Class<? extends Enum> enumClass;

    @Override
    public void initialize(EnumValid enumValid) {
        enumClass = enumValid.enumClass();
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }

        Enum[] enumConstants = enumClass.getEnumConstants();
        for (Enum enumConstant : enumConstants) {
            if (str.equals(enumConstant.name())) {
                return true;
            }
        }
        return false;
    }
}
