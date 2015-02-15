/**
 * Created by Administrator on 2015/2/15.
 */
public class QuickSort {
    int[] array;
    int begin;
    int end;

    QuickSort(int[] array){
        this.array = array;
        begin = 0;
        end = array.length - 1;
    }

    public void quickSort(int[] array,int begin,int end){
        int majorDate = 0;
        if(begin < end){
            majorDate = partition(array,begin,end);
            quickSort(array,begin,majorDate - 1);
            quickSort(array,majorDate,end);
        }
    }

    public int partition(int[] array,int begin,int end){
        int theMajor = array[end];
        int i = begin - 1;

        for(int j = begin;j < end;j++) {
            if (array[j] <= theMajor) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1,end);
        return i + 1;
    }

    public void swap(int number1,int number2){
        int temp;
        temp = array[number1];
        array[number1] = array[number2];
        array[number2] = temp;
     }

    public void show(){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void showQuickSort(){
        System.out.println("快速排序结果为：");
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
    }
}
