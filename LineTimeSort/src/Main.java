/**
 * Created by Administrator on 2015/2/16.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[]{19,29,56,72,29,70,45,18,99,56};
        int[] outArray = new int[array.length];

        Integer[] integerArray = new Integer[array.length];
        for(int i = 0;i < array.length;i++){
           integerArray[i] = array[i];
        }

        ArraySort array1 = new ArraySort(array);
        array1.show();

        //array1.countingSort(array,outArray,100);
        //array1.countingSort2(array,100);
        array1.bucketSort(array);
    }
}
