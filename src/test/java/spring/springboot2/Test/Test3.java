package spring.springboot2.Test;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author : ZJ
 * @date : 19-8-6 下午5:48
 */
public class Test3 {


    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;

        BitSet bitSet = new BitSet(count);


        for (int number : numbers) {
            bitSet.set(number - 1);
        }
        System.out.println(bitSet);

        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {

            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);

            System.out.println(++lastMissingIndex);
        }
    }

    private static void printMissingNumber1(int[] numbers, int count) {
        int missingCount = count - numbers.length;

        BitSet bitSet = new BitSet(count + 1);

        for (int number : numbers) {
            bitSet.set(number);
        }

        System.out.println(bitSet);

        for (Integer i = 1; i < count; i++) {
            if (!bitSet.get(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 缺一个值
     *
     * @param numbers
     * @param totalCount
     * @return
     */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }


    public static int[] removeDuplicates(int[] numbersWithDuplicates) {

        // Sorting array to bring duplicates together
        Arrays.sort(numbersWithDuplicates);

        int[] result = new int[numbersWithDuplicates.length];
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;
    }

    public static void main(String args[]) {


        int[][] test = new int[][]{
                {1, 1, 2, 2, 3, 4, 5},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 1, 1, 1, 1, 3},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
        }

//        // one missing number
//        getMissingNumber(new int[]{2, 4, 6}, 6);
//
//        int[] iArray = new int[]{1, 2, 3, 5};
//        int missing = getMissingNumber(iArray, 5);
//        System.out.printf("Missing number in array %s is %d %n",
//                Arrays.toString(iArray), missing);


    }


}
