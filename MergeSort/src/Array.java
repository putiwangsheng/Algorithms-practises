/**
 * Created by Administrator on 2015/1/8.
 */

public class Array {
    int[] array;
    int first;
    int last = array.length - 1;
    private int times = 0;

    public Array() {
    }

    Array(int[] array){
        this.array = array;
    }

    public void showArray(){
        for(int i = 0;i < array.length;i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void mergeSort(int[] array ,int first,int last,int mergeWay){
        if(first < last) {
            int middle = (first + last) / 2;

            mergeSort(array, first, middle,mergeWay);
            mergeSort(array, middle + 1,last,mergeWay);

            if(mergeWay == 1) {
                mergeHaveSentinel(array, first, middle, last);
            }
            else if(mergeWay == 2) {
                mergeHaveNoSentinel(array, first, middle, last);
            }
        }
    }

    public void mergeHaveSentinel(int[] array,int first,int middle,int last){
        int[] array1 = new int[middle - first + 2];
        int[] array2 = new int[last - middle + 1];
        array1[array1.length - 1] = Integer.MAX_VALUE;
        array2[array2.length - 1] = Integer.MAX_VALUE;
        times += 4;


        for(int i = 0;i < array1.length - 1;i++){
            array1[i] = array[first + i];

        }

        for(int i = 0;i < array2.length - 1;i++){
            array2[i] = array[middle + 1 + i];
        }

        for(int i = first,index1 = 0,index2 = 0;i <= last;i++) {
            if (array1[index1] < array2[index2]) {
                array[i] = array1[index1];
                index1++;

            } else {
                array[i] = array2[index2];
                index2++;
            }
        }
    }

    public void mergeHaveNoSentinel(int[] array,int first,int middle,int last) {
        int[] array1 = new int[middle - first + 1];
        int[] array2 = new int[last - middle];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array[first + i];
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[middle + 1 + i];
        }

        for (int i = first, index1 = 0, index2 = 0; i <= last; i++) {
            if (index1 < array1.length && index2 < array2.length) {
                if (array1[index1] < array2[index2]) {
                    array[i] = array1[index1];
                    index1++;
                } else {
                    array[i] = array2[index2];
                    index2++;
                }
            } else if (index1 < array1.length) {
                array[i] = array1[index1];
                index1++;
            } else if (index2 < array2.length) {
                array[i] = array2[index2];
                index2++;
            }
        }
    }
}
