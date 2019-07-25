package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-7-18 下午4:31
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] == 9) {
                digits[i] = 0;
            }else{
                digits[i]=digits[i]+1;
            }
            if(digits[i]!=0){
                break;
            }
        }

        if(digits[0]==0){
            int[] result = new int[digits.length + 1];
            result[0]=1;
            return result;
        }


        return digits;
    }

    public static void main1(String[] args) {

        int[] arrays = {9};
        int[] ints = plusOne(arrays);

        System.out.println(ints.length);
    }

}
