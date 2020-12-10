package spring.springboot2.Until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author : ZJ
 * @date : 19-6-24 上午11:23
 */
public class DateUntil {

    private static ThreadLocal<DateFormat> threadLocal =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    private static ThreadLocal<DateFormat> threadLocal2 =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy.MM.dd"));

    public static String pare() {
        DateFormat dateFormat = threadLocal2.get();
        String format = dateFormat.format(new Date());
        return format;
    }

    /**
     * java8使用DateTimeFormatter 格式化
     * 
     * @param args
     */
    public static void main(String[] args) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        String format = now.format(pattern);
        System.out.println(format);
        System.out.println(LocalDate.parse("2020-12-10", pattern));
    }

}
