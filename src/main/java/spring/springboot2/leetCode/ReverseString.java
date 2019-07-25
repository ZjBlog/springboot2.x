package spring.springboot2.leetCode;

import org.apache.commons.lang.StringUtils;

/**
 * @author : ZJ
 * @date : 19-7-25 上午10:40
 */
public class ReverseString {

    public static char[] reverseString(char[] s){


        char temp;
        for(int i=0,j=s.length-1;i<j;i++,j--){
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
        return  s;
    }

    public static void main2(String[] args) {
        String str="hello";
        char[] chars = reverseString(str.toCharArray());

        System.out.println(new String(chars));
    }
}
