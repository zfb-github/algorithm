package basic.class01;

import java.util.Arrays;

/**
 * @Author: zfb
 * @Date: 2021/1/23 10:11
 * @Description: 二分查找
 */
public class Code04BSExist {

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 100;
        int testTime = 100000;

        for (int i = 0; i < testTime; i++) {

            int[] src = ArrUtil.generateRandomArray(maxSize, maxValue);
            Arrays.sort(src);

            int value = (int) (Math.random() * (maxValue + 1) - Math.random() * maxValue);
            if (isExist(src,value) != test(src,value)){
                System.out.println(Arrays.toString(src));
                System.out.println(value);
                break;
            }
        }

//        int[] arr = {-70, -64, -35, -33, 25, 41, 42, 60};
//        System.out.println(isExist(arr,-35));

    }

    static boolean isExist(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == value) {
                return true;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else if (arr[mid] > value) {
                right = mid - 1;
            }

        }
        return false;
    }

   static boolean test(int[] arr,int value){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return true;
            }
        }

        return false;
    }

}
