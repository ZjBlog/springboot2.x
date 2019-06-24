package spring.springboot2.exercise.zeren;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : ZJ
 * @date : 19-5-30 下午4:39
 */
@Component
public class ZeRenService {
//
//    @Autowired
//    private List<Filter> filters;
//
//    public void mockedClient() {
//        Integer integer=0;
//        for (Filter filter : filters) {
//            if (!filter.filter(integer)) {
//                return;
//            }
//        }
//    }

    private final Map<String, Filter> calPriceMap = new ConcurrentHashMap<>();

    public ZeRenService(Map<String, Filter> calPriceMap) {
        this.calPriceMap.clear();
        calPriceMap.forEach((k, v)-> this.calPriceMap.put(k, v));
    }

    public Boolean cal(String calPriceType) {
        if (!StringUtils.isEmpty(calPriceType)) {
            return calPriceMap.get(calPriceType).filter(12);
        }
        return false;
    }
}
