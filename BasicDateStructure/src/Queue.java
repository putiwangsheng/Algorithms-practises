/**
 * Created by Administrator on 2015/1/29.
 */
public class Queue {
    private int[] queuearray;
    private int size;

    private int head = 0;
    private int tail = 0;

    private boolean isEmpty = true;
    private boolean isFull = false;

    Queue(int size){
        if(size == 0){
            System.out.println("size为0，无法创建队列");
        }
        this.size = size;
        queuearray = new int[size];
    }

    //入队
    public void enQueue(int date){
        if(isFull){
            System.out.println("队列已满，无法入队");
            return;        //如果没有return在deQueue时tail初始值会为1，影响判断是否队列是否为空
        }
        else if(isEmpty){
           isEmpty = false;
        }

        queuearray[tail] = date;
        //队列满时，置tail为0
        if(tail == queuearray.length - 1){
            tail = 0;
        }
        else{
            tail++;
        }

        if(tail == head){
            isFull = true;
        }
    }

    //出队
    public int deQueue(){
        if(isEmpty){
            System.out.println("队列为空，无数据出队");
            return 0;
        }
        else if(isFull){
            isFull = false;
        }

        int date = queuearray[head];
        if(head == queuearray.length - 1){
            head = 0;
        }
        else{
            head++;
        }

        if(head == tail){
            isEmpty = true;
        }
        return date;
    }
}
