/**
 * Created by Administrator on 2015/2/12.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[]{1,8,3,2,9,16,5,6,10,4};
        HeapSort heapsort = new HeapSort(array);
        heapsort.show();
        heapsort.heapSort(array);
        heapsort.showHeapSort();
    }
}
