package spring.springboot2.x.util.validate;

import spring.springboot2.x.util.validate.EnumValid.EnumValids;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/30 15:33
 * @Description 枚举注解校验
 * 枚举校验,用在String上,并且是必填参数上,校验是否转化成枚举
 * 注意String 必须对应的枚举的name()
 * <p>
 * 参照@NotNull注解
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(EnumValids.class)
@Documented
@Constraint(validatedBy = {EnumValidator.class})
public @interface EnumValid {

    String message() default "枚举类型错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 允许的枚举
     *
     * @return
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * Defines several {@link EnumValid} annotations on the same element.
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface EnumValids {
        EnumValid[] value();
    }
}
