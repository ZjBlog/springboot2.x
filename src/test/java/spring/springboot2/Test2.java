package spring.springboot2;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

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

    public static void main(String[] args) {
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
}
