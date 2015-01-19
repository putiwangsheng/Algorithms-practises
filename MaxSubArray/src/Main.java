/**
 * Created by Administrator on 2015/1/16.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[]{2,4,-7,6,-9,3,8,-10};

        int way1 = 1;
        int way2 = 2;

        System.out.print("递归法，最大子数组为：");
        TheMaxSubArray maxSubArray1 = new TheMaxSubArray(array);
        maxSubArray1.showMaxSumSubArray(way1);
        System.out.println();

        System.out.print("暴力法，最大子数组为：");
        TheMaxSubArray maxSubArray2 = new TheMaxSubArray(array);
        maxSubArray2.showMaxSumSubArray(way2);
    }
}
