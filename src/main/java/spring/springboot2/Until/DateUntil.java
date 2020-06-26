package spring.springboot2.Until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ZJ
 * @date : 19-6-24 上午11:23
 */
public class DateUntil {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat
        initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private static ThreadLocal<DateFormat> threadLocal2 = ThreadLocal.withInitial(() -> {
                return new SimpleDateFormat("yyyy.MM.dd");
            }
    );

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("ok", "dd");
        map.put("ok1", "dd");
        map.put("ok2", "ppp");
        map.put("ok3", "ppp");
        map.put("ok4", "ppp");
        map.put("ok5", "ppp");
        map.put("ok6", "ppp");
    }

}
