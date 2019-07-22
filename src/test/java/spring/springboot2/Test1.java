package spring.springboot2;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import spring.springboot2.leetCode.MyCircularQueue;

import java.util.*;

/**
 * @author : ZJ
 * @date : 19-7-16 下午1:52
 */
public class Test1 {

    //@Test
    public void test1() {

        MyCircularQueue myCircularQueue = new MyCircularQueue(4);

        myCircularQueue.enQueue(4);
        myCircularQueue.enQueue(6);

        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        System.out.println("The first element is: " + q.peek());
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }


    //@Test
    public void test2() {
        int[] arrays = {1, 7, 3, 6, 5, 6};


        if (arrays.length < 2) {
            return;
        }
        int leftsum = 0;
        int rightsum = 0;

        Integer sumall = 0;

        for (int array : arrays) {
            sumall += array;
        }

        for (int i = 1; i < arrays.length; i++) {
            leftsum += arrays[i - 1];
            rightsum = sumall - leftsum - arrays[i];
            if (leftsum == rightsum) {
                System.out.println(arrays[i]);
                break;
            }
        }
    }

    //@Test
    public void test3() {
        Integer number = 3;
        if (number < 2) {
            throw new IllegalArgumentException("number is: " + number + ", need >= 2");
        }


        List<Integer> result = new ArrayList<Integer>();
        int i = 2;

        while (i <= number) {
            if (number % i == 0) {
                result.add(i);
                number = number / i;
                i = 2;
            } else {
                i++;
            }
        }
        System.out.println(result.toString());
    }


  //  @Test
    public void test4() {
        int[] nums = {3, 6, 1, 0};


        int max = nums[0];
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
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

        return;
    }


    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main2(String[] args) {
        int[] arr1 = {1, 2, 3};

        int[] arr2 = {4, 5, 6};

        int[] arr3 = {7, 8, 9};


        int[][] arrays = {arr1, arr2, arr3};

      int[] f= findDiagonalOrder(arrays);
        for (int i : f) {
            System.out.println(i);
        }

    }
    public static int[] findDiagonalOrder(int[][] matrix) {


        if (matrix.length==0||matrix[0].length==0)return new int[0];


        int col=matrix.length,row=matrix[0].length;

        int nums=col*row,m=0,n=0;

        int res[]=new int[nums];

        boolean flag=true;

        for(int i=0;i<nums;i++){
            res[i]=matrix[m][n];
            if(flag){
                n+=1; m-=1;
            }else{
                n-=1; m+=1;
            }
            if(m>=col){
                m-=1; n+=2; flag=true;
            }else if(n>=row){
                n-=1; m+=2; flag=false;
            }
            if(m<0){
                m=0; flag=false;
            }else if(n<0){
                n=0; flag=true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
            String sql="select * from user where id=%d";
            System.out.println(String.format(sql,789));
    }
}