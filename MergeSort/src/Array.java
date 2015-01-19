/**
 * Created by Administrator on 2015/1/16.
 */
public class Array {
    private int[] array;
    private int first;
    private int last;
    private int times = 0;

    Array(int[] array){
        first = 0;
        last = array.length - 1;
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

    public void mergeSortChange(int[] array,int first,int last){
        if(first < last - 2) {
            int middle = (first + last) / 2;

            mergeSortChange(array, first,middle);
            mergeSortChange(array,middle + 1,last);
            insertionSort(array,first,middle);
            insertionSort(array,middle + 1,last);

            mergeHaveSentinel(array,first,middle,last);
        }
    }

    public void insertionSort(int[] array,int first,int last) {
        for (int i = first + 1; i < last; i++) {
            int key = array[i];
            if (key > array[i - 1]) {
                key = array[i];
            } else if (key < array[i - 1]) {
                array[i - 1] = key;
                array[i] = array[i - 1];
                key = array[i + 1];
            }
        }
    }
}
