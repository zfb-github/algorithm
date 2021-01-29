package basic.class03;

/**
 * @Author: zfb
 * @Date: 2021/1/29 17:02
 * @Description: todo
 */

public class Node {


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }


    public   int value;

    public Node next;

    public Node(){}

    public Node(int value){
        this.value = value;
    }



}
