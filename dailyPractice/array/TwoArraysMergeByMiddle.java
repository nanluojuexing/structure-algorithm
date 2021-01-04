package dailyPractice.array;

import java.util.Arrays;

/**
 * 两个有序数组，求中间元素位置，不开辟新的空间，空间复杂度要求O(1)
 *
 */
public class TwoArraysMergeByMiddle {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int[] array1 = {1,6, 8, 9, 10};
        mergeArrayByMiddle(array,array1);

    }

    public static void mergeArrayByMiddle(int[] array,int[] array1) {
        for (int i = 0; i < array.length + array1.length; i++) {
            for (int j = i + 1; j < array.length + array1.length; j++) {
                int m;
                int n;
                int temp;
                if (i < array.length) {
                    m = array[i];
                } else {
                    m = array1[i - array.length];
                }
                if (j < array.length) {
                    n = array[j];
                } else {
                    n = array1[j - array.length];
                }
                if(m > n){
                    temp = m;
                    if (i < array.length) {
                        array[i] = n;
                    } else {
                        array1[i - array.length] = n;
                    }
                    if (j < array.length) {
                        array[j] = temp;
                    } else {
                        array1[j - array.length] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
    }
}
