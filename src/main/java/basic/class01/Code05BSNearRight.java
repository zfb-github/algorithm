package basic.class01;

import java.util.Arrays;

/**
 * @Author: zfb
 * @Date: 2021/1/23 11:00
 * @Description: 在一个有序数组中，找<=某个数最右侧的位置
 */
public class Code05BSNearRight {

    public static void main(String[] args) {

        int maxSize = 10;
        int maxValue = 100;
        int testTime = 3;

        for (int i = 0; i < testTime; i++) {
            int[] src = ArrUtil.generateRandomArray(maxSize, maxValue);
            Arrays.sort(src);

            int value = (int) (Math.random() * maxValue);
            if (nearRight(src, value) != test(src, value)) {
                System.out.println(Arrays.toString(src));
                System.out.println(value);
                break;
            }
        }


    }

    static int nearRight(int[] arr, int value) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }

        int left = 0;
        int right = arr.length - 1;

        int mid = 0;
        while (right >= left) {
            mid = left + ((right - left) >> 1);

            if (arr[mid] <= value) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return index;
    }

    static int test(int[] arr, int value) {
        int index = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                index = i;
                break;
            }

        }
        return index;
    }


}
