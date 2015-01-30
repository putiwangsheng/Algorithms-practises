import java.util.Random;

/**
 * Created by Administrator on 2015/1/29.
 */
public class Main {
    public static void main(String[] args){
        queue();
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
}
