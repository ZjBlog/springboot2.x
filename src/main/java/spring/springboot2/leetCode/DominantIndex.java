package spring.springboot2.leetCode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author : ZJ
 * @date : 19-7-18 下午4:08
 */
public class DominantIndex {

    public static int dominantIndex(int[] nums){
        int max = nums[0];
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                index = i;
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != index && (max < nums[i] * 2)) {
                index=-1;
                break;
            }
        }

        return index;
    }

    /**
     * 找到数组中做大的和第二大的进行比较
     * @param nums
     * @return
     */
    public static int dominantIndex1(int[] nums){
        int first = 0;
        int firstIndex = 0;
        int second = 0;

        for(int i = 0; i < nums.length; i++){
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                firstIndex = i;
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        return first / 2 >= second ? firstIndex : -1;
    }
    public static void main1(String[] args) {
        int[] arrays = {3,6,1,0};

        System.out.println(dominantIndex1(arrays));
    }
}
