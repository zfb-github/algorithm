package basic.class01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zfb
 * @Date: 2021/1/23 13:47
 * @Description: 局部最小值问题
 */
public class Code06BSAwesome {


    public static void main(String[] args) {

        int maxSize = 10;
        int maxValue = 100;
        int testTime = 100000;

        for (int i = 0; i < testTime; i++) {

            int[] arr = generateArr(maxSize, maxValue);
            int lessIndex = getLessIndex(arr);
            List<Integer> test = test(arr);
            if (!test.contains(lessIndex)) {
                System.out.println(Arrays.toString(arr));
            }

        }


    }

    static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }


        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;

        int mid;
        while (right >= left) {
            mid = left + ((right - left) >> 1);

            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }

            /*if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                right = mid - 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            }*/
        }
        return -1;
    }

    static List<Integer> test(int[] arr) {

        List<Integer> list = new ArrayList<>();

        if (arr.length == 1) {
            list.add(0);
            return list;
        }

        if (arr[0] < arr[1]) {
            list.add(0);
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            list.add(arr.length - 1);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                list.add(i);
            }
        }

        return list;
    }

    static int[] generateArr(int maxSize, int maxValue) {
        // 数组长度
        var arr = new int[(int) (Math.random() * maxSize) + 1];
        arr[0] = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
        for (int i = 1; i < arr.length; i++) {

            while (true) {
                int v = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
                if (v != arr[i - 1]) {
                    arr[i] = v;
                    break;
                }
            }
        }

        return arr;
    }

}
