package basic.class03;

/**
 * @Author: zfb
 * @Date: 2021/1/29 19:30
 * @Description: 删除给定的值(这个值可能有多个)
 */
public class Code02DeleteGivenValue {


    static Node deleteValue(Node node, int num) {

        while (node != null) {
            if (node.value != num) {
                break;
            }
            node = node.next;
        }


        Node res = node;
        Node pre = node;
        Node cur = node.next;

        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return res;
    }


}
