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

            var srcArr = ArrUtil.generateRandomArray(maxSize, maxValue);

            var copy1 = Arrays.copyOf(srcArr, srcArr.length);
            insertionSort(copy1);

            var copy2 = Arrays.copyOf(srcArr, srcArr.length);
            Arrays.sort(copy2);

            if (!ArrUtil.isEquals(copy1, copy2)) {
                isTrue = false;
                System.out.println(Arrays.toString(srcArr));
                break;
            }
        }

        System.out.println(isTrue ? "正确!" : "错误!");

    }


    static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j - 1] > arr[j]; j--) {
                ArrUtil.swap(arr, j, j - 1);
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




}
