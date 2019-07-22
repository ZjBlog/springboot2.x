package spring.springboot2;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author : ZJ
 * @date : 19-7-19 下午2:24
 */
public class Test2 {


    //@Test
    public void test() {

        String haystack = "lhlelllo";
        String needle = "ll";

        if (haystack == null || needle == null) {
            System.out.println(0);
        }

        if (haystack.length() == 0 || needle.length() == 0) {
            System.out.println(0);
        }


        if (needle.length() > haystack.length()) {
            System.out.println(-1);
        }
        char[] chars = haystack.toCharArray();

        char[] chars1 = needle.toCharArray();

        for (int i = 0, j = 0; i < chars.length; i++) {

            if (chars[i] == chars1[j]) {
                j++;
            } else {
                j = 0;
            }
            if (j == chars1.length) {
                System.out.println(i - chars1.length + 1);
                break;
            }
        }
        System.out.println("====-1");
    }


    @Test
    public void test2() {

        String[] str = new String[]{"flower", "flow", "flight"};

        String min = str[0];
        for (String s : str) {
            if (min.length() > s.length()) {
                min = s;
            }
        }


        char[] chars = min.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i < str.length; i++) {
                if (!str[i].startsWith(String.valueOf(chars).trim())) {
                    chars[j] = ' ';
                    break;
                }
                if(i==str.length-1){
                }
            }
        }


    }

    public static void main(String[] args) {
        char[] chars = "str".toCharArray();

        chars[2] = ' ';

        System.out.println(String.valueOf(chars).trim());
    }

}
