package basic.class02;

import java.util.*;

/**
 * @Author: zfb
 * @Date: 2021/1/25 19:57
 * @Description:
 * 1、一个数组中有一种数出现K次，其他数都出现了M次，M>1,k<M
 *  找到，出现K次的数；
 *  要求，额外空间负责度O(1)，时间复杂度O(n)。
 */
public class Code03KM1 {

    public static void main(String[] args) {

        int maxKinds = 10;
        int range = 200;
        int testTime = 100000;

        int max = 9;

        for (int i = 0; i < testTime; i++) {

            int a = (int) (Math.random() * 9 + 1);
            int b = (int) (Math.random() * 9 + 1);

            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (m == k) {
                m++;
            }

            int[] arr = generateRandomArr(maxKinds, range, k, m);
            int res1 = onlyKTime(arr, k, m);
            int res2 = test(arr, k, m);
            if (res1 != res2) {
                System.out.println("错误!");
                System.out.println(Arrays.toString(arr));
                break;
            }

        }

//        int[] arr = {-1, -1, -1, -2, -2, 3, 3, 3, 4, 4, 4};
//        System.out.println(onlyKTime(arr, 2, 3));
//
//        System.out.println(test(arr, 2, 3));

    }

    static int[] generateRandomArr(int maxKinds, int range, int k, int m) {
        int kTimeNum = randomNumber(range);

        // 至少2种数
        int numKind = (int) (Math.random() * maxKinds + 2);

        int[] arr = new int[k + (numKind - 1) * m];

        int i = 0;
        for (; i < k; i++) {
            arr[i] = kTimeNum;
        }
        numKind--;

        Set<Integer> set = new HashSet<>();
        set.add(kTimeNum);

        while (numKind != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKind--;
            for (int j = 0; j < m; j++) {
                arr[i++] = curNum;
            }
        }

        for (int index = 0; index < arr.length; index++) {

            int j = (int) (Math.random() * arr.length);
            int temp = arr[index];
            arr[index] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }

    private static int randomNumber(int range) {
        return (int) ((Math.random() * range + 1) - (Math.random() * range));
    }

    static int onlyKTime(int[] arr, int k, int m) {

        var tempArr = new int[32];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < tempArr.length; j++) {

                // 方式一
                tempArr[j] += (arr[i] >> j) & 1;

                // 方式二
//                if ((arr[i] & (1 << j)) != 0) {
//                    tempArr[j]++;
//                }

            }
        }

        var res = 0;

        for (int i = 0; i < tempArr.length; i++) {
            if ((tempArr[i] % m) != 0) {
//                res += (1 << i);
                res |= (1 << i);
            }
        }

        return res;
    }

    static int test(int[] arr, int k, int m) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {

            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == k) {
                return entry.getKey();
            }

        }
        return 0;

    }

}
