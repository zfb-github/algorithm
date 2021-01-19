package basic.class01;

import javax.print.attribute.standard.PrinterURI;
import java.util.Arrays;

/**
 * @Author: zfb
 * @Date: 2021/1/17 11:12
 * @Description: 冒泡排序
 */
public class Code02BubbleSort {

    public static void main(String[] args) {

        int maxSize = 10;
        int maxValue = 100;
        int testTime = 100000;

        boolean isSucceed = true;

        for (int i = 0; i < testTime; i++) {
            int[] src = generateRandomArr(maxSize, maxValue);

            int[] copy1 = Arrays.copyOf(src, src.length);
            bubbleSort(copy1);

            int[] copy2 = Arrays.copyOf(src, src.length);
            Arrays.sort(copy2);

            if (!isEquals(copy1, copy2)) {
                isSucceed = false;
                System.out.println("算法错误,原数组: " + Arrays.toString(src));
                break;
            }

        }

        System.out.println(isSucceed ? "Nice!" : "Fucking Fucked!");

    }

    static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1 == null || arr2 == null) {
            return false;
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

    static int[] generateRandomArr(int maxSize, int maxValue) {
        var arr = new int[(int) (Math.random() + 1)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * maxValue);
        }

        return arr;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }

}
