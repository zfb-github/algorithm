package basic.class03;

import com.sun.nio.file.ExtendedWatchEventModifier;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zfb
 * @Date: 2021/1/29 17:02
 * @Description: 反转链表
 */
public class Code01ReverseList {

    public static void main(String[] args) {

        int len = 5;
        int maxValue = 100;
        int testTime = 10;

        for (int i = 0; i < testTime; i++) {
            Node node = generateRandomLinkedList(len, maxValue);
            List<Node> nodeList = copyNode(node);

            Node res1 = reverseList(node);

            if (!isEquals(res1, nodeList)) {
                System.out.println(node);
                System.out.println(res1);
                System.out.println("单向链表错误;");
                break;
            }


            DoubleNode doubleNode = generateRandomDoubleLinkedList(len, maxValue);
            List<DoubleNode> doubleNodeList = copyDoubleNode(doubleNode);

            DoubleNode dNode = reverseDoubleList(doubleNode);

        }

    }

    private static DoubleNode reverseDoubleList(DoubleNode doubleNode) {

        DoubleNode res = null;
        DoubleNode next = null;

        while (doubleNode != null) {
            next = doubleNode.next;
            doubleNode.next = res;
            doubleNode.pre = next;
            res = doubleNode;
            doubleNode = next;
        }

        return res;
    }


    static boolean isEquals(Node n1, List<Node> nodeList) {
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            Node node = nodeList.get(i);
            if (node.value != n1.value) {
                return false;
            }
            n1 = n1.next;
        }
        return true;
    }

    static List<Node> copyNode(Node head) {
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list;
    }

    static List<DoubleNode> copyDoubleNode(DoubleNode head) {
        List<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list;
    }

    static Node test(Node head) {
        if (head == null) {
            return null;
        }

        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        Node res = list.get(list.size() - 1);
        Node temp = res;
        for (int i = list.size() - 2; i >= 0; i--) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        return res;
    }

    static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }

        Node res = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = res;
            res = head;
            head = next;

        }

        return res;
    }


    static Node generateRandomLinkedList(int len, int maxValue) {
        int size = (int) (Math.random() * len + 1);

        Node head = new Node((int) (Math.random() * maxValue + 1));
        Node temp = head;
        size--;

        for (int i = 0; i < size; i++) {
            temp.next = new Node((int) (Math.random() * maxValue + 1));
            temp = temp.next;
        }
        return head;
    }


    static DoubleNode generateRandomDoubleLinkedList(int len, int maxValue) {
        int size = (int) (Math.random() * len + 1);

        DoubleNode head = new DoubleNode((int) (Math.random() * maxValue + 1));
        DoubleNode temp = head;
        size--;

        for (int i = 0; i < size; i++) {
            DoubleNode next = new DoubleNode((int) (Math.random() * maxValue + 1));
            temp.next = next;
            next.pre = temp;

            temp = temp.next;
        }
        return head;
    }

}
