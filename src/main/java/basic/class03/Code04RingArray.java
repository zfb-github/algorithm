package basic.class03;

/**
 * @Author: zfb
 * @Date: 2021/1/29 19:48
 * @Description: 循环链表 实现队列
 */
public class Code04RingArray {


    public static class MyQueue {
        int[] arr;
        int pushI;
        int popI;
        int size;
        int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            this.limit = limit;
            pushI = 0;
            popI = 0;
            size = 0;
        }

        public void push(int v) {
            if (size == limit) {
                throw new RuntimeException("队列满了;");
            }
            size++;
            pushI = pushI >= arr.length ? pushI % arr.length : pushI;
            arr[pushI++] = v;
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列为空;");
            }
            size--;
            popI = popI >= arr.length ? popI % arr.length : popI;
            return arr[popI++];
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }

}
