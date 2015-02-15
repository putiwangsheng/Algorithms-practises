/**
 * Created by Administrator on 2015/2/15.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[]{2,8,7,1,3,5,6,4};

        QuickSort quickSort = new QuickSort(array);
        quickSort.show();
        quickSort.quickSort(array,0,7);
        quickSort.showQuickSort();
    }
}
