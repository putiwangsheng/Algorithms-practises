/**
 * Created by Administrator on 2015/1/16.
 */
public class Main {
    public static void main(String[] args){
        int[] array = new int[]{2,4,-7,6,-9,3,8,-10};

        TheMaxSubArray maxSubArray = new TheMaxSubArray(array);
        maxSubArray.showMaxSumSubArray();
    }
}
