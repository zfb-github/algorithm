package basic.class01;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @Author: zfb
 * @Date: 2021/1/23 09:33
 * @Description: 插入排序
 */
public class Code03InsertionSort {

    public static void main(String[] args) {

        var maxSize = 100;
        var maxValue = 10;
        var testTime = 100000;

        boolean isTrue = true;

        for (int i = 0; i < testTime; i++) {

            var srcArr = generateRandomArr(maxSize, maxValue);

            var copy1 = Arrays.copyOf(srcArr, srcArr.length);
            insertionSort(copy1);

            var copy2 = Arrays.copyOf(srcArr, srcArr.length);
            Arrays.sort(copy2);

            if (!isEquals(copy1, copy2)) {
                isTrue = false;
                System.out.println(Arrays.toString(srcArr));
                break;
            }
        }

        System.out.println(isTrue ? "正确!" : "错误!");

    }


    static boolean isEquals(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        if (arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }

        }
        return true;
    }


    static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);
            }
        }

       /* for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }*/

    }

    static void swap(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }

    static int[] generateRandomArr(int maxSize, int maxValue) {
        var arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * maxValue);
        }
        return arr;
    }


}
