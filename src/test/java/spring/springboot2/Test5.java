package spring.springboot2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test5 {

    private static int dosomething(Integer i) {
        try {

            i++;
            if (i / 0 > 0) {
                i++;
            }

        } catch (Exception e) {
            i++;
        }
        i++;

        return i++;
    }

    public static void main11(String[] args) {
        System.out.println(dosomething(10));


        /**
         * +0.5后向下取整。所以结果是-2。
         */
        System.out.println(Math.round(-2.7));
        System.out.println(Math.round(2.6));

        boolean fa = false;
        long f = 12;
        System.out.println(f + "");
    }

    public static void main22(String[] args) {


        System.out.println(count1(11));


    }

    /**
     * 厄拉多塞筛法
     * @param x
     * @return
     */
    private static Integer count1(int x) {

        boolean[] arr = new boolean[x + 1];
        // 初始化数组为 true
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        for (int k = 2; k< x; k++) {
            if (arr[k]) {
                for (int i = k; i * k < x; i++) {
                    arr[k * i] = false; // k * i is not prime
                }
            }
        }

        int count = 0;
        for (int j = 2; j < x; j++) {
            if (arr[j]) {
                count++;
            }
        }
        return count;

    }

    private static Integer count(int i) {
        if (i < 2) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        Integer count = 1;
        for (int k = 2; k < i; k++) {

            if (isPrime(k)) {
                count++;
            }
        }
        return count;
    }

    private static Boolean isPrime(int i) {


        for (Integer j = 2; j < (i / 2) + 1; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 不常出现字符串 空格分隔，
     * @return
     */
    private List<String> str(){
        String A="apple apple"; String B="banana"; // [banana]

        String C="this is dog";String D="this is cat"; //[dog,cat]

        return null;
    }

    public static void main12(String[] args) {
        String A="this is dog";String B="this is a cat";

        Map<String,Integer> map=new HashMap<>();


        String[] s = A.split(" ");
        for (String s1 : s) {
            if(map.get(s1)==null){
                map.put(s1,1);
            }else{
                map.put(s1,map.get(s1)+1);
            }

        }

        String[] s2 = B.split(" ");

        for (String s1 : s2) {
            if(map.get(s1)==null){
                map.put(s1,1);
            }else{
                map.put(s1,map.get(s1)+1);
            }
        }

        for (String s1 : map.keySet()) {

            if(map.get(s1)==1){
                System.out.println(s1);
            }

        }

        System.out.println();
    }
}
