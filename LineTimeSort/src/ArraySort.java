import java.util.LinkedList;

/**
 * Created by Administrator on 2015/2/16.
 */
public class ArraySort {
    private int[] array;
    private int[] outPutArray;
    private int begin;
    private int end;
    private int limitedNumber;

    ArraySort(int[] array){
        begin = 0;
        end = array.length - 1;
        this.array = array;
        outPutArray = new int[array.length];
    }

    public void show(){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    //计数排序
    //way1
    public void countingSort(int[] array, int[] outPutArray,int limitedNumber){
        int[] newArray = new int[limitedNumber + 1];

        for(int i = 0;i < newArray.length;i++){
            newArray[i] = 0;
        }

        for(int i = 0;i < array.length;i++){
            newArray[array[i]] += 1;
        }

        for(int i = 1;i < newArray.length;i++){
            newArray[i]  = newArray[i] + newArray[i - 1];
        }

        for(int i = array.length - 1;i >= 0;i--){
            outPutArray[newArray[array[i]] - 1] = array[i];
            newArray[array[i]] = newArray[array[i]] - 1;
        }

        System.out.print("\n计数排序方法1结果为：");
        for(int i = 0;i < array.length;i++){
            System.out.print(outPutArray[i] + " ");
        }
    }

    //way2
    public void countingSort2(int[] array,int limitedNumber){
        int[] newArray = new int[limitedNumber + 1];

        for(int i = 0;i < newArray.length;i++){
            newArray[i] = 0;
        }

        for(int i = 0;i < array.length;i++){
            newArray[array[i]] += 1;
        }

        int arrayIndex = 0;
        for(int newArrayIndex = 0;newArrayIndex < newArray.length;newArrayIndex++){
            for(int i = 0;i < newArray[newArrayIndex];i++){
                array[arrayIndex] = newArrayIndex;
                arrayIndex++;
            }
        }
        System.out.print("\n计数排序方法2结果为：");
        showSorted();
    }

    //桶排序
    public void bucketSort(int[] array) {
        Bucket[] bucketArray = Bucket.getBucket(array);

        for (int i = 0, index = 0; i < bucketArray.length; i++) {
            Integer[] changeToArray = bucketArray[i].linkedList.toArray(new Integer[bucketArray[i].linkedList.size()]);

            for(int j = 0;j < changeToArray.length;j++) {
                insertionSort(changeToArray);
                array[index] = changeToArray[j];
                index++;
            }
        }
        System.out.print("\n\n桶排序结果为：");
        showSorted();
    }

    public void insertionSort(Integer[] array){
        for(int i = 1;i < array.length;i++){
            int key = array[i];
            while (i - 1 >= 0 && key < array[i - 1]){
                array[i] = array[i - 1];
                i--;
            }
            array[i] = key;
        }
    }

    public void showSorted(){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
    }
}
