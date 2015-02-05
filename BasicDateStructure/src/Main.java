import java.util.Random;

/**
 * Created by Administrator on 2015/1/29.
 */
public class Main {
    public static void main(String[] args){
        //queue();
        //binTree();
        normalTree();
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

    public static void normalTree(){
        final int NULL = Integer.MAX_VALUE;
        int[] normalTreeArray = {0,1,5,NULL,6,NULL,7,NULL,NULL,2,NULL,3,NULL,4,NULL,NULL};

        NormalTree normalTreeTest = new NormalTree(normalTreeArray);
        normalTreeTest.showNormalTree();
    }
}
