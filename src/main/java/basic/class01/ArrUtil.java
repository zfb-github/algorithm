package basic.class01;

/**
 * @Author: zfb
 * @Date: 2021/1/23 10:12
 * @Description: todo
 */
public class ArrUtil {

    /**
     * 生成一个随机数组
     *
     * @param maxSize  数组中最大的值
     * @param maxValue 数组的最大长度
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 数组长度
        var arr = new int[(int) (Math.random() * maxSize) + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
        }

        return arr;
    }

    public static boolean isEquals(int[] arr1, int[] arr2) {

        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        if (arr1 == null) {
            return true;
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


    public static void swap(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }

}
