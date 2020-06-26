package spring.springboot2.Test;

import java.util.Arrays;

/**
 * @author : ZJ
 * @date : 19-8-7 下午3:57
 */
public class Head {
    public static void main(String[] args) {
        // int []arr = {7,6,7,11,5,12,3,0,1};
        int[] arr = {314,298,508,123,486,145};
        System.out.println("排序前：" + Arrays.toString(arr));
//        sort(arr);
        insertionSort(arr);
        //quickSort(arr, 0, arr.length - 1);
        System.out.println("排序前：" + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //1.构建大顶堆
        //先调整堆(选择一个最大值放到堆顶)
        //找到最后一个非叶子节点就是：长度/2-1
        //遍历所有非叶子节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            System.out.println(j + "==" + Arrays.toString(arr));
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            System.out.println(j + "==" + Arrays.toString(arr));
            adjustHeap(arr, 0, j);//重新对堆进行调整
            System.out.println(j + "==" + Arrays.toString(arr));
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param length
     */
    // 调整堆，使得堆顶元素值大于等于其子节点值
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始

            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }//找到左右子树中最大的

            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                //如：i=1 k=3  则把子树赋值父节点 继续比较k=3 下的左右子树  计算i的值在应该在哪
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 直接插入排序
     *
     * @param array
     */

    public static void insertionSort(int[] array) {
        if (array == null) {
            return;
        }
        // 和冒泡排序有些类似，这里是遍历趟数
        for (int i = 0; i <2; i++) {
            // 精髓是从局部有序，到整体有序
            int temp = array[i]; // 当前基准元素
            int j;
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1]; // 下一个元素比基准元素大，下一个元素向后移动
            }
            // 最后比较当前元素和基准元素大小
            if (array[j] > temp) {
                array[j] = temp;
            }
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (array == null) {
            return;
        }

        //左侧是大的
        //右侧是小的
        if (left < right) {

            // 选取一端值为基准值 左端为基点
            int i = left;
            int j = right;
            int temp = array[left];

            while (i < j) {
                // 如果 j 处值大于等于基准值，那么不用交换数据，直接将 j 向前移动，
                //右边先走
                // 直到 i 等于 j 或者    j 处值比基准值小 条件
                while (i < j && array[j] <= temp) {
                    j--;
                }
                // 如果 i 处值小于等于基准值，那么将i向后移动就可以了
                while (i < j && array[i] >= temp) {
                    i++;
                }

// 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
                if (i < j) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }

            // 将基准数放到中间的位置（基准数归位）
            array[left] = array[i];
            array[i] = temp;
            quickSort(array, 0, i - 1);
            quickSort(array, i + 1, right - 1);

        }
    }
}
//https://www.cnblogs.com/onepixel/p/7674659.html