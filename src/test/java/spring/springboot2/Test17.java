package spring.springboot2;

import org.junit.Test;

/**
 * @author : ZJ
 * @date : 19-9-18 下午2:38
 */
public class Test17 {

    public void find(int leftIndex, int rightIndex, int val, int arr[]) {
        int midIndex = (rightIndex + leftIndex) / 2;
        // 中间的数
        if (rightIndex >= leftIndex) {
            int midVal = arr[midIndex];
            if (midVal > val) {
                find(leftIndex, midIndex - 1, val, arr);
            } else if (midVal < val) {
                find(midIndex + 1, rightIndex, val, arr);
            } else {
                System.out.println("===========:" + midIndex);
            }

        }else{
            System.out.println("===========不存在");
        }
    }

    @Test
    public void test() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 22, 33, 55};

        find(0, arr.length-1, 330, arr);
    }
}
