package spring.springboot2;

<<<<<<< HEAD
public class Test17 {

    private static int x = 100;

    public static void main(String[] args) {

        for(Short  i =0;i<100;i++){

        }

    }

}

class Base {
    void test() {
        System.out.println("00");
    }

    public float getNum(){
        return 3f;
    };
}

class Child extends Base {

    void test() {
        System.out.println(6 + 6 + "dd");


        String aStr = " One ";
        String bStr = aStr;
        String s = aStr.toUpperCase();
        aStr.trim();
        System.out.println("[" + aStr + "," + bStr + "]");
    aStr.indexOf('d');

        int[] d = new int[25];
        System.out.println(d[24]);
    }
}

class C1 extends Base{
   protected   void test(){}
}
=======
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
>>>>>>> 936ebd606abff0b484e2c3b93445fa73f59cab22
