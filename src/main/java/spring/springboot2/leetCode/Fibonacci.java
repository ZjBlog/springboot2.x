package spring.springboot2.leetCode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author : ZJ
 * @date : 19-8-8 下午4:59
 */
public class Fibonacci {


    private static Integer fibonacci(Integer n) {

        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);

    }


    private static Integer fibonacci1(Integer n) {

        if (n <= 1) {
            return 1;
        }

        Integer pre = 1;
        Integer pre_pre = 1;
        Integer res = 0;
        for (Integer i = 2; i <= n; i++) {
            res = pre + pre_pre;
            pre_pre = pre;
            pre = res;
        }
        return res;

    }

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        System.out.println(fibonacci1(100));
        System.out.println((System.currentTimeMillis() - start));

    }
}
