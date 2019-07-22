package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-7-18 下午2:46
 */
public class NumsCente {
    public static int pivotIndex(int[] nums) {
        int leftsum = 0;
        int rightsum = 0;

        Integer sumall=0;

        for (int array : nums) {
            sumall+=array;
        }

        /**
         * 左侧默认是0
         */
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                leftsum=0;
            }else{
                leftsum +=nums[i-1];
            }
            rightsum=sumall-leftsum-nums[i];
            if(leftsum==rightsum){
                return i;
            }
        }
        return -1;
    }
    public static int pivotIndex1(int[] nums) {
        int leftsum = 0;
        int rightsum=0;

        for (int array : nums) {
            rightsum+=array;
        }

        for (int i = 0; i < nums.length; i++) {
            rightsum-=nums[i];
            if(rightsum==leftsum){
                return i;
            }
            /**
             * 右侧是全部
             */
            /**
             * 比较完之后计算左侧的
             *
             */
            leftsum+=nums[i];
        }
        return -1;
    }

    public static void main1(String[] args) {
        int[] arrays = {-1,-1,-1,0,1,1};

        int i = pivotIndex1(arrays);
        System.out.println(i);

    }
}
