package spring.springboot2;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/4/1 18:48
 */
public class Test2 {
    public static void main3(String[] args) {
//        System.out.println(null instanceof Object);
//
//        List<String> list = Lists.newArrayList("A","BA");
//
//        Map<Integer, String> integerStringImmutableMap = Maps.uniqueIndex(list, String -> String.length());
//        System.err.println(integerStringImmutableMap.keySet());
//        System.out.println(integerStringImmutableMap.get(2));
//
//        System.out.println("http://scf3.front.test.jd.com/scf/financingApply/financingApplyPage?flag=1&productCode=PR000001".contains("?"));
//        System.out.println("http://scf3.front.test.jd.com/scf/jdScfQueryView/queryView".contains("?"));
//
//        System.out.println(StringUtils.contains("http://scf3.front.test.jd.com/scf/jdScfQueryView/queryView","?"));
//        System.out.println(StringUtils.contains("http://scf3.front.test.jd.com/scf/financingApply/financingApplyPage?flag=1&productCode=PR000001","?"));



    }

    public static void main9(String[] args) {
//        List<String> list=new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        String[] arrays=new String[list.size()];
//        list.toArray(arrays);
//        for (String array : arrays) {
//            System.out.println("====:"+array);
//        }

        String str="12,7";

        String[] split = StringUtils.split(str, ",");
        List<String> list = Arrays.asList(split);
        Set<String> set=new HashSet<>(list);
        System.out.println(set.size());

        int size = 500;
        int size1 = 500;
        System.out.println(size==size1);
        System.out.println(UUID.randomUUID().toString().replaceAll("-","").length());

    }

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(3);
        BigDecimal divide = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        divide.doubleValue();
        System.out.println(numberFormat.format(divide.doubleValue()));
    }
}
