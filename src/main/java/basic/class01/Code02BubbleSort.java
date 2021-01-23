package basic.class01;

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
            int[] src = ArrUtil.generateRandomArray(maxSize,maxValue);

            int[] copy1 = Arrays.copyOf(src, src.length);
            bubbleSort(copy1);

            int[] copy2 = Arrays.copyOf(src, src.length);
            Arrays.sort(copy2);

            if (!ArrUtil.isEquals(copy1, copy2)) {
                isSucceed = false;
                System.out.println("算法错误,原数组: " + Arrays.toString(src));
                break;
            }

        }

        System.out.println(isSucceed ? "Nice!" : "Fucking Fucked!");

    }


    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrUtil.swap(arr, j, j + 1);
                }
            }
        }
    }



}
