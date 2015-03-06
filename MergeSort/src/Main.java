/**
 * Created by Administrator on 2015/1/16.
 */
public class Main {
    public static void main(String[] args){
        int originArray[] = new int[]{3,41,52,26,38,57,9,49};
        int mergeWay1 = 1;
        int mergeWay2 = 2;

        for(int i = 0;i < originArray.length;i++){
            System.out.print(originArray[i] + " ");
        }
        System.out.println();
        System.out.println("归并排序结果为：");

//        Array sort1 = new Array(originArray);
//        sort1.mergeSort(originArray,0,7,mergeWay1);
//        sort1.showArray();
//        System.out.println();

//        Array sort2 = new Array(originArray);
//        sort2.mergeSort(originArray,0,7,mergeWay2);
//        sort2.showArray();
//        System.out.println();

        Array sort3 = new Array(originArray);
        sort3.mergeSortChange(originArray,0,7);
        sort3.showArray();
    }
}
