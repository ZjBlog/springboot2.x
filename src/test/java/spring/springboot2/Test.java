package spring.springboot2;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/5/29 16:40
 */
public class Test {

    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate.getMonthValue());
//
//        BigDecimal v = new BigDecimal(0.1);
//
//        System.out.println(v.compareTo(BigDecimal.ZERO));
//        System.out.println("1".equals(null));
//        Integer f = null;
//        System.out.println(f == 1);

//        BigDecimal bigDecimal = BigDecimal.valueOf(1832.1200);
//        System.out.println(bigDecimal.longValue());


        List<Integer> list = Arrays.asList(1, 2, 3, 1, 5);
        int sum = list.stream().mapToInt(s -> getSum(s, 1)).sum();
        System.out.println(sum);

    }

    private static int getSum(int code, int code1) {
        return code + code1;
    }
}
