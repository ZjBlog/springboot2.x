package spring.springboot2.leetCode;

import java.util.Arrays;

/**
 * @author : ZJ
 * @date : 19-7-25 上午10:55
 */
public class ArrayPairSum {

    public static int arrayPairSum(int[] nums) {

        int num = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                num += nums[i];
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[] nums={1,4,2,3};

        System.out.println(arrayPairSum(nums));

    }
}
