package spring.springboot2.exercise.zeren;

import org.springframework.stereotype.Component;

/**
 * @author : ZJ
 * @date : 19-5-30 下午4:37
 */
@Component("duration")
public class DurationFilter implements Filter {
    @Override
    public boolean filter(Integer task) {
        System.out.println("时效性检验");
        return true;
    }
}
