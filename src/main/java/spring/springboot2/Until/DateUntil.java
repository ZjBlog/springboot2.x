package spring.springboot2.Until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

}
