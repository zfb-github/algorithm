package basic.class01;

import java.util.Arrays;

/**
 * @Author: zfb
 * @Date: 2021/1/17 10:27
 * @Description: 选择排序
 */
public class Code01SelectionSort {

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 100;
        int testTime = 10000;
        boolean isTrue = true;

        for (int i = 0; i < testTime; i++) {

            var src = ArrUtil.generateRandomArray(maxSize, maxValue);

            var copy1 = Arrays.copyOf(src, src.length);
            selectionSort(copy1);

            var copy2 = Arrays.copyOf(src, src.length);
            Arrays.sort(copy2);

            if (!ArrUtil.isEquals(copy1, copy2)) {
                isTrue = false;
                System.out.println("算法错误,原始数组: " + Arrays.toString(src));
                System.out.println("算法错误,自己实现: " + Arrays.toString(copy1));
                System.out.println("算法错误,jdk内置: " + Arrays.toString(copy2));
                break;
            }
        }

        System.out.println(isTrue ? "算法正确!" : "Fucking Fucked!");

    }

    /**
     * 选择排序
     * @param arr
     */
    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int temp = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 取出一个最小的数的下标索引
                temp = arr[temp] > arr[j] ? j : temp;
            }
            swap(arr, i, temp);
        }
    }

    /**
     * 交换两个数组中的值
     * @param arr
     * @param i1
     * @param i2
     */
    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

}
