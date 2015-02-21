/**
 * Created by Administrator on 2015/2/5.
 */
public class LinkedList {
    private Node head = null;

    public void setHead(int data) {
        head = new Node();
        head.setData(data);
        head.setNext(null);
    }

    //查找
    public Node listSearch(int key) {
        Node theNode = head;
        while (theNode != null) {
            if (theNode.getData() == key) {
                return theNode;
            }
            else if (theNode.getData() != key) {
                theNode = theNode.getNext();
            }
        }
        return null;
    }

    //插入节点
    public Node listInsert(Node prevNode,int date){
        Node theInsertNode = new Node();
        theInsertNode.setData(date);
        theInsertNode.setNext(null);

        if(prevNode.getNext() != null){
            Node nextNode = prevNode.getNext();
            theInsertNode.setNext(nextNode);
        }
        prevNode.setNext(theInsertNode);

        return null;
    }

    //删除结点
    public Node listDelete(Node prevNode){
        if(prevNode.getNext() != null){
            Node theDeleteNode = prevNode.getNext();
            if(theDeleteNode.getNext() != null){
                prevNode.setNext(theDeleteNode.getNext());
            }
            else{
                prevNode.setNext(null);
            }
        }
        return null;
    }


    //删除指定节点
    public void deleteTheNodeDate(int key){
        Node theNode = head;
        if(head == null){
            return;
        }
        else if(head.getData() == key){
            head = null;
        }

        while (theNode.getNext() != null){
            Node nextNode = theNode.getNext();
            if(nextNode.getData() == key){
                listDelete(theNode);
            }
            else{
                theNode = theNode.getNext();
            }
        }
    }

    public void show(){
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public Node getMinNode(){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }

        Node theNode = head;
        Node theMinNode = head;

        while(theNode != null) {
            if (theNode.getData() <= theMinNode.getData()) {
                theMinNode = theNode;
            }
            theNode = theNode.getNext();
        }

        return theMinNode;
    }

    public Node getSuccessor(Node theNode){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }

        Node currentNode = head;
        Node successor = theNode;

        while(currentNode != null){
            if(currentNode.getData() > successor.getData()){
                successor = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }

        currentNode = head;
        while(currentNode != null){
            if(currentNode.getData() > theNode.getData() && currentNode.getData() < successor.getData()){
                successor = currentNode;
            }
            currentNode = currentNode.getNext();
        }

        if(successor.getData() == theNode.getData()){
            return null;
        }
        return successor;
    }

    public void showSorted(){
        Node minimum = getMinNode();
        System.out.print(minimum.getData() + " ");
        Node theSuccessor = getSuccessor(minimum);
        while(theSuccessor != null){
            System.out.print(theSuccessor.getData() + " ");
            theSuccessor = getSuccessor(theSuccessor);
        }
    }
}

