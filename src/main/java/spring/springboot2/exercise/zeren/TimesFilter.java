package spring.springboot2.exercise.zeren;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : ZJ
 * @date : 19-5-30 下午4:38
 */
@Component("time")
public class TimesFilter implements Filter {
    @Override
    public boolean filter(Integer task) {
        System.out.println("次数限制检验");
        return true;
    }
}
