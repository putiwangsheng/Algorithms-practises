import java.util.LinkedList;

/**
 * Created by Administrator on 2015/2/19.
 */
public class Bucket {
    LinkedList<Integer> linkedList;//链表

    Bucket(){
        linkedList = new LinkedList<Integer>();
    }

    public static Bucket[] getBucket(int[] array){
        Bucket[] buckets = new Bucket[array.length];
        for(int i = 0;i < array.length;i++){
            buckets[i] = new Bucket();
        }

        for(int i = 0;i < array.length;i++){
            int bucketIndex = array[i]/10;
            buckets[bucketIndex].linkedList.add(array[i]);
        }

//        for(int i= 0;i < array.length;i++){
//            Integer[] changeToArray = buckets[i].linkedList.toArray(new Integer[buckets[i].linkedList.size()]);
//        }
        return buckets;
    }

}
