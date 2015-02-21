/**
 * Created by Administrator on 2015/2/5.
 */
public class Node {
    private int data = 0;
    private Node next = null;

    Node(){

    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
