import java.util.*;
/**
 * Created by Administrator on 2015/2/22.
 */
public class Main {
    public static void main(String[] args){
        //queue();
        //binTree();
        //normalTree();
        linkedList();
    }

    public static void queue(){
        Queue q = new Queue(10);
        Random random = new Random();
        for(int i = 0;i < 11;i++){
            int number = random.nextInt(100);
            q.enQueue(number);
            System.out.print(number + " ");
        }
        System.out.println();

        for(int i = 0;i < 11;i++){
            int number = q.deQueue();
            System.out.print(number + " ");
        }
    }

    public static void binTree(){
        final int NULL = Integer.MAX_VALUE;
        int[] binTreeArray = {8,2,4,NULL,NULL,1,NULL,NULL,5,3,NULL,7,NULL,NULL,NULL};

        BinTree binTreeTest = new BinTree(binTreeArray);
        binTreeTest.showBinTree();
    }

    public static void normalTree() {
        final int NULL = Integer.MAX_VALUE;
        int[] normalTreeArray = {0, 1, 5, NULL, 6, NULL, 7, NULL, NULL, 2, NULL, 3, NULL, 4, NULL, NULL};

        NormalTree normalTreeTest = new NormalTree(normalTreeArray);
        normalTreeTest.showNormalTree();
    }

    public static void linkedList(){
        Scanner input = new Scanner(System.in);

        LinkedList linkedListTest = new LinkedList();
        Random random = new Random();
        int headDate = random.nextInt(100);
        linkedListTest.setHead(headDate);
        Node currentNode = linkedListTest.listSearch(headDate);
        for(int i = 0;i < 10;i++){
            int currentDate = random.nextInt(100);
            linkedListTest.listInsert(currentNode,currentDate);
            currentNode = linkedListTest.listSearch(currentDate);
        }
        linkedListTest.show();

        System.out.print("请输入要删除的值：");
        int data = input.nextInt();
        linkedListTest.deleteTheNodeDate(data);
        linkedListTest.show();

        System.out.println("按从小到大排序为：");
        linkedListTest.showSorted();
    }
}
