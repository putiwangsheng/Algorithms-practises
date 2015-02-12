import com.sun.javafx.runtime.async.AbstractRemoteResource;

/**
 * Created by Administrator on 2015/2/12.
 */
public class HeapSort {
    private int[] array;
    private int heapSize;

    HeapSort(int[] array){
        this.array = array;
        heapSize = array.length;
    }

    public int left(int rootIndex){
        return (rootIndex * 2 + 1);
    }

    public int right(int rootIndex){
        return (rootIndex * 2 + 2);
    }

    public void show(){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    public void heapSort(int[] array){
        buildMaxHeap(array);
        for(int i = array.length - 1;i >= 0;i--){
            swap(0,i);
            heapSize = heapSize - 1;
            maxHeapIfy(array,0);
        }
    }

    public void buildMaxHeap(int[] array){
        for(int i = array.length/2 - 1;i >= 0;i--){
            maxHeapIfy(array,i);
        }
    }

    public void maxHeapIfy(int[] array,int rootIndex){
        int leftIndex = left(rootIndex);
        int rightIndex = right(rootIndex);
        int largest = 0;

        if(leftIndex < heapSize && array[leftIndex] > array[rootIndex]) {
            largest = leftIndex;
        }
        else{
            largest = rootIndex;
        }

        if(rightIndex < heapSize && array[rightIndex] > array[largest]){
            largest = rightIndex;
        }

        if(largest != rootIndex){
            swap(rootIndex,largest);
            maxHeapIfy(array,largest);
        }
    }

    public void swap(int number1,int number2){
        int temp;
        temp = array[number1];
        array[number1] = array[number2];
        array[number2] = temp;
    }

   public void showHeapSort(){
       System.out.println("\n堆排序后：");

       for(int i = 0;i < array.length;i++){
           System.out.print(array[i] + " " );
       }
   }

}
