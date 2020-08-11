package spring.springboot2.x.util.validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/23 20:37
 * @Description 校验工具类
 */
public class JavaxValidator {
    private static final ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    private static final Validator validator;

    public JavaxValidator() {

    }

    public static <T> List<String> invalidValueMsg(T obj) {
        Set<ConstraintViolation<T>> result = validator.validate(obj, new Class[0]);
        if (result != null && result.size() != 0) {
            List<String> msg = new ArrayList(result.size());
            Iterator i$ = result.iterator();

            while (i$.hasNext()) {
                ConstraintViolation violation = (ConstraintViolation) i$.next();
                msg.add(violation.getMessage());
            }

            return msg;
        } else {
            return null;
        }
    }

    public static String validate(Object obj) {
        Set<ConstraintViolation<Object>> result = validator.validate(obj, new Class[0]);
        if (result != null && result.size() != 0) {
            Iterator i$ = result.iterator();
            if (i$.hasNext()) {
                ConstraintViolation violation = (ConstraintViolation) i$.next();
                return violation.getMessage();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    static {
        validator = vf.getValidator();
    }
}
