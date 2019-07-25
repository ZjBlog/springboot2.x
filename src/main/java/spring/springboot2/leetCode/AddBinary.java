package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-7-22 下午1:59
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    /**
     *如果j<0的话则将其当做0来处理
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            /**
             *  b.charAt(j) - '0'
             *  char 数值 - '0' 之后是 0 1
             */
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            /**
             * 判断j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
             */
            /**
             * sum%2是在做二进制取模运算，比如sum=2，这时候将sum%2=0放入结果集中
             */
            ans.append(sum % 2);

            /**
             * 是否进位
             */
            ca = sum / 2;
            /**
             * // 这里是计算进位，比如sum=2，ca = 1，ca表示进位的意思，满2进1
             */
        }
        /**
         * //这一步表示是不是最后还有进位，比如1+1 = 10，10前面的1就是最后留存的进位，需要将其放进去
         */
        ans.append(ca == 1 ? ca : "");

        return ans.reverse().toString();
    }


    public static void main1(String[] args) {

        System.out.println(addBinary("", "100"));
    }
}
