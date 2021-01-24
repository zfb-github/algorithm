package basic.class02;

/**
 * @Author: zfb
 * @Date: 2021/1/24 20:03
 * @Description: 关于 异或 的题目
 */
public class Code02EvenTimesOddTimes {


    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 1, 2, 4, 5, 6, 7, 8, 8};
//        oddTimeNumber(arr);

//        getRightNum(4);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 1, 2, 4, 5, 6, 7, 8};
        printOddTimesNum2(arr);

    }

    /**
     * 1、一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
     *
     * @param arr
     */
    static void oddTimeNumber(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        System.out.println(res);
    }


    /**
     * 2、怎么把一个int类型的数，提取出最右侧的1来
     *
     * @param i
     */
    static void getRightNum(int i) {
        // i & (!i+1)  <==>  i & -i
        System.out.println(i & (~i + 1));
        System.out.println(i & -i);

    }

    /**
     * 3、一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     *
     * @param arr
     */
    static void printOddTimesNum2(int[] arr) {

        int res1 = 0;
        int res2 = 0;

        for (int i = 0; i < arr.length; i++) {
            res1 ^= arr[i];
        }

        int onlyOne = res1 & -res1;

        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & onlyOne) != 0) {
                res2 ^= arr[i];
            }
        }

        res1 ^= res2;

        System.out.println("res1=" + res1 + " ,res2=" + res2);
    }


}
