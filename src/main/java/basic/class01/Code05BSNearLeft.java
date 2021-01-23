package basic.class01;

import java.util.Arrays;

/**
 * @Author: zfb
 * @Date: 2021/1/23 10:41
 * @Description: 在一个有序数组中，找>=某个数最左侧的位置
 */
public class Code05BSNearLeft {


    public static void main(String[] args) {

        int maxSize = 10;
        int maxValue = 100;

        int testTime = 100000;

        for (int i = 0; i < testTime; i++) {

            int[] arr = ArrUtil.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);

            int value = (int) (Math.random() * maxValue + 1);
            if (nearLeft(arr, value)!=test(arr,value)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(maxValue);
                break;
            }
        }

    }


    static int nearLeft(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        int mid = 0;

        int index = -1;

        while (right >= left) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < value) {
                left = mid +1;
            } else {
                index = mid;
                right = mid -1;
            }
        }

        return index;
    }


    static int test(int[] arr, int value) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                index = i;
                break;
            }

        }
        return index;
    }


}
