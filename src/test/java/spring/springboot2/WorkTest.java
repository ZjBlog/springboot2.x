package spring.springboot2;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/11/20 14:33
 */
public class WorkTest {

    public static void main(String[] args) {

//        boolean de = StringUtils.contains("ade,ddd", "");
//        System.out.println(de);
//
//        System.out.println(Math.ceil((150/16 + 1) *16 /3.0) * 4);
//            Integer id=1;
//        if (null != id || id > 0) {
//           System.out.println("====");
//        }else{
//            System.out.println("aaaaaaa");
//        }

//        List<String> list=new ArrayList<String>();
//
//System.out.println(CollectionUtils.isEmpty(list));

//        Date date=new Date();
//
//        Instant instant = date.toInstant();
//        ZoneId zoneId = ZoneId.systemDefault();
//        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
//        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
//        System.out.println(localDate.getYear());
//        System.out.println(localDate.getMonthValue());
//        System.out.println(localDate.getDayOfMonth());


        List<String> strings = Arrays.asList(StringUtils.split("1",","));
        System.out.println(strings);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);

        calendar.set(calendar.get(Calendar.YEAR), 11, 31, 0, 0, 0);

        Date date = calendar.getTime();

        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());

        System.out.println(calendar.getTime());
        System.out.println("================================");
        System.out.println("EECD901EC3F0162E1C619453A6EBCA125FEBFE882A12D63ECA70B8278286D647156D6961C9E9B7E916ADB644F5E33C76A828CEB88DCE3B5BCECA828C9357C4EFC051C3CF35264D7D7C4D4DABA9DA9BC28FCAAD6BCE7CF598BD5097878C289FD427EBFCB236B77C2ADE6A4CC5B2284326E3F098A23B28332018E02064F0E2D2C45C657C35014D1F334A6EB91FF778CFC5F2046C87818E2D2C21FA6A3FC3A95062".length());


    }
}
