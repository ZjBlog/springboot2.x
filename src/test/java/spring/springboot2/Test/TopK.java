package spring.springboot2.Test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : ZJ
 * @date : 19-9-6 下午3:38
 */
public class TopK {

    @Test
    public void test() {
        int[] nums = {10, 8, 9, 89, 5, 7, 8, 6, 1, 48, 45, 748, 145};
        testTopK(nums, 8);
    }

    public void testTopK(int[] nums, int k) {

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }

        for (int re : res) {
            System.out.print(re + ",");
        }
        System.out.println("====");
        //找到最后一个非叶子节点
        for (int j = res.length / 2 - 1; j >= 0; j--) {
            heade(res, j);
        }
        for (int re : res) {
            System.out.print(re + ",");
        }

        System.out.println("=============================");
        for (int i = k; i < nums.length; i++) {
            if(nums[i]>res[0]){
                res[0]=nums[i];
                heade(res,0);
            }
        }
        for (int re : res) {
            System.out.print(re + ",");
        }


    }

    //小顶
    private void heade(int[] res, int j) {

        int temp = res[j];

        for (int i = 2 * j + 1; i < res.length; i = 2 * i + 2) {

            if (i + 1 < res.length && res[i] > res[i + 1]) {
                i++;
            }
            if (res[i] < temp) {
                res[j] = res[i];
                j = i;
            } else {
                break;
            }
        }
        res[j] = temp;
    }
}
