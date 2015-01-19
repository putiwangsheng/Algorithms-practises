/**
 * Created by Administrator on 2015/1/16.
 */
public class TheMaxSubArray {
    private int[] array;
    private int low;
    private int high;

    TheMaxSubArray(int[] array){
        this.array = array;
        low = 0;
        high = array.length - 1;
    }

    public void showMaxSumSubArray(int way){
        MaxSum maxsum1 = findMaxSumSubArray(array,low,high);
        MaxSum maxsum2 = maximumSumArrayViolent();

        if(way == 1) {
            for (int i = maxsum1.getLow(); i <= maxsum1.getHigh(); i++) {
                System.out.print(array[i] + " ");
            }
        }
        else if(way == 2){
            for (int i = maxsum2.getLow(); i <= maxsum2.getHigh(); i++) {
                System.out.print(array[i] + " ");
            }
        }

    }

    //递归
    public MaxSum findMaxSumSubArray(int[] array,int low,int high){
        if(low == high){
            MaxSum maxSum = new MaxSum(low,high,array[low]);
                    return maxSum;
        }

        int mid = (low + high)/2;

        MaxSum leftMaxSumSubArray = findMaxSumSubArray(array, low, mid);
        MaxSum rightMaxSumSubArray = findMaxSumSubArray(array,mid + 1,high);
        MaxSum crossingMaxSumSubArray = findCrossingMaxSumSubArray(array,low,mid,high);

        if(leftMaxSumSubArray.getMaxSum() >= rightMaxSumSubArray.getMaxSum() && leftMaxSumSubArray.getMaxSum() >= crossingMaxSumSubArray.getMaxSum()){
            return leftMaxSumSubArray;
        }
        else if(rightMaxSumSubArray.getMaxSum() >= leftMaxSumSubArray.getMaxSum() && rightMaxSumSubArray.getMaxSum() >= crossingMaxSumSubArray.getMaxSum()){
            return rightMaxSumSubArray;
        }
        else {
            return crossingMaxSumSubArray;
        }
    }

    //跨越中间的最大子数组
    public MaxSum findCrossingMaxSumSubArray(int[] array,int low,int mid,int high){
        MaxSum[] leftSubArray = new MaxSum[mid - low + 1];
        MaxSum[] rightSubArray = new MaxSum[high - mid];

        MaxSum leftMaxSubArray = new MaxSum();
        MaxSum rightMaxSubArray = new MaxSum();
        MaxSum crossingMaxSubArray = new MaxSum();


        for(int i = mid;i >= low;i--){
            if(i == mid) {
                leftSubArray[mid - i] = new MaxSum(i, mid, array[i]);
            }
            else {
                int leftlow = i;
                int lefthigh = mid;
                int leftsum = leftSubArray[mid - i - 1].getMaxSum() + array[i];
                leftSubArray[mid - i] = new MaxSum(leftlow, lefthigh, leftsum);
            }
        }

        for(MaxSum leftMaxSumSubArray:leftSubArray){
            if(leftMaxSumSubArray.getMaxSum() > leftMaxSubArray.getMaxSum()){
                leftMaxSubArray = leftMaxSumSubArray;
            }
        }

        for(int i = mid + 1;i <= high;i++){
            if(i == mid + 1) {
                rightSubArray[i - mid - 1] = new MaxSum(mid + 1, i, array[i]);
            }
            else{
                int rightlow = mid + 1;
                int righthigh = i;
                int rightsum = rightSubArray[i - mid - 2].getMaxSum() + array[i];
                rightSubArray[i - mid - 1] = new MaxSum(rightlow, righthigh, rightsum);
            }
        }

        for(MaxSum rightMaxSumSubArray:rightSubArray){
            if(rightMaxSumSubArray.getMaxSum() > rightMaxSubArray.getMaxSum()){
                rightMaxSubArray = rightMaxSumSubArray;
            }
        }

        crossingMaxSubArray.setLow(leftMaxSubArray.getLow());
        crossingMaxSubArray.setHigh(rightMaxSubArray.getHigh());
        crossingMaxSubArray.setMaxSum(leftMaxSubArray.getMaxSum() + rightMaxSubArray.getMaxSum());

        return crossingMaxSubArray;
    }

    //暴力求解
    public MaxSum maximumSumArrayViolent(){
        MaxSum maxSumSubArray = new MaxSum();
        MaxSum[][] sumSumArray = new MaxSum[array.length][array.length];

        for(int i = 0;i < array.length;i++){
            for(int j = 0; j < array.length;j++){
                sumSumArray[i][j] = new MaxSum(i,j,0);
            }
        }

        for(int i = 0;i < array.length;i++){
            for(int j = i;j < array.length;j++){
                if(j > i) {
                    int thelow = i;
                    int thehigh = j;
                    int thesum = sumSumArray[i][j - 1].getMaxSum() + array[j];
                    sumSumArray[i][j] = new MaxSum(thelow, thehigh, thesum);
                }
                else{
                    sumSumArray[i][j] = new MaxSum(i,j,array[j]);
                }
            }
        }

        for(int i = 0;i < array.length;i++){
            for(int j = 0;j < array.length;j++){
                if(sumSumArray[i][j].getMaxSum() > maxSumSubArray.getMaxSum()){
                    maxSumSubArray = sumSumArray[i][j];
                }
            }
        }

        return maxSumSubArray;
    }

}
