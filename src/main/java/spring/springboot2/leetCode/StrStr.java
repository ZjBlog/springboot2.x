package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-7-19 下午2:49
 */
public class StrStr {

    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return 0;
        }
        if(needle.length() == 0){
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] chars = haystack.toCharArray();

        char[] chars1 = needle.toCharArray();

        for (int i = 0, j = 0; i < chars.length; i++) {

            System.out.println(chars[i]);
            System.out.println(chars1[j]);
            System.out.println(i +"============"+j);
            if (chars[i] == chars1[j]) {
                j++;
            } else {
                i=i-j;
                j = 0;
            }
            if (j == chars1.length) {
                return i - chars1.length + 1;
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        "ss".indexOf("s");
        System.out.println(strStr("mississippi","issip"));
    }
}
