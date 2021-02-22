package spring.springboot2.Test2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/12/16 11:18
 * @Description
 */
public class Test {
    public static void main1(String[] args) {

        Map<String, Object> map = new HashMap();
        map.put("custName", "测试,");

        // String[] custNames = map.get("custName").toString().split(",");

        String[] custNames = StringUtils.split(map.get("custName").toString(), ",");

        List<String> list = new ArrayList<>();
        list.add("2234");
        list.add("2234");
        System.out.print(list.size());
        System.out.print(list.toString());
        System.out.print(list.contains(null));
        System.out.println(list.toString());

        // 返回Object 强转其它类型出错
        Object[] objects = list.toArray();
        // 必须使用集合的 toArray(T[] array)，传入的是类型完全一
        // 致、长度为 0 的空数组。
        /**
         * 说明：使用 toArray 带参方法，数组空间大小的 length： 1） 等于 0，动态创建与 size 相同的数组，性能最好。 2） 大于 0 但小于 size，重新创建大小等于 size 的数组，增加 GC
         * 负担。 3） 等于 size，在高并发情况下，数组创建完成之后，size 正在变大的情况下，负面影响与 2 相同。 4） 大于 size，空间浪费，且在 size 处插入 null 值，存在 NPE 隐患
         */
        String[] strings = list.toArray(new String[0]);
        System.out.println(strings.length);
        map.forEach((key, value) -> {
            System.out.println(key);
        });
    }

    public static void main2(String[] args) {
        // 获取明天零点时间戳
        LocalDate localDate = LocalDate.now();
        // 当前日期+1
        localDate = localDate.plusDays(1);
        LocalDateTime dateTime =
            LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0, 0);
        long timestamp = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(timestamp);
        System.out.println((timestamp - System.currentTimeMillis()) / 1000 / 3600);

        System.out.println(StringUtils.startsWith("132", "2"));
    }

    public static void main11(String[] args) {
        BigDecimal decimal = BigDecimal.valueOf(32000).subtract(BigDecimal.valueOf(61000))
            .divide(BigDecimal.valueOf(61000), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L));
        System.out.println("ddd:" + decimal);
        if (decimal.compareTo(BigDecimal.valueOf(20L * (-1))) == -1) {
            System.out.println("小于-20%");
        } else {
            System.out.println("大于-20%");
        }
    }

    public static void main3(String[] args) {
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.MONTH, 0);
        now.set(Calendar.DAY_OF_MONTH, 1);
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);

        System.out.println(now.getTime());
        FastDateFormat sdf = FastDateFormat.getInstance("yyyy-MM-dd");
        String format = sdf.format(now.getTime());
        System.out.println(format);
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1.10");

        BigDecimal bigDecimal1 = bigDecimal.subtract(new BigDecimal("1.01"));
        System.out.println(bigDecimal1);
    }
}
