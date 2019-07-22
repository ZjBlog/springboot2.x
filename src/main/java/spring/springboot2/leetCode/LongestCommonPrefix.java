package spring.springboot2.leetCode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author : ZJ
 * @date : 19-7-19 下午5:03
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs == null) {
            return "";
        }
        if(strs.length==0){
            return "";
        }
        String min = strs[0];
        for (String s : strs) {
            if (min.length() > s.length()) {
                min = s;
            }
        }
        char[] chars = min.toCharArray();
        for (int j = chars.length-1; j >=0; j--) {
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(String.valueOf(chars).trim())) {
                    chars[j] = ' ';
                    break;
                }
                if (i == strs.length - 1) {
                    return String.valueOf(chars).trim();
                }
            }
        }

        return "";

    }

    public static void main(String[] args) {
        String[] str = new String[]{};

        System.out.println(longestCommonPrefix(str));

    }
}
