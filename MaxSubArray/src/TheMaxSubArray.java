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
        SubArray maxsum1 = findMaxSumSubArray(array,low,high);
        SubArray maxsum2 = maximumSumArrayViolent();
        SubArray maxsum3 = theThirdWayOfSubArray();

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
        else if(way == 3){
            for (int i = maxsum3.getLow(); i <= maxsum3.getHigh(); i++) {
                System.out.print(array[i] + " ");
            }
        }

    }

    //递归
    public SubArray findMaxSumSubArray(int[] array,int low,int high){
        if(low == high){
            SubArray subArray = new SubArray(low,high,array[low]);
                    return subArray;
        }

        int mid = (low + high)/2;

        SubArray leftSubArraySubArray = findMaxSumSubArray(array, low, mid);
        SubArray rightSubArraySubArray = findMaxSumSubArray(array,mid + 1,high);
        SubArray crossingSubArraySubArray = findCrossingMaxSumSubArray(array,low,mid,high);

        if(leftSubArraySubArray.getSum() >= rightSubArraySubArray.getSum() && leftSubArraySubArray.getSum() >= crossingSubArraySubArray.getSum()){
            return leftSubArraySubArray;
        }
        else if(rightSubArraySubArray.getSum() >= leftSubArraySubArray.getSum() && rightSubArraySubArray.getSum() >= crossingSubArraySubArray.getSum()){
            return rightSubArraySubArray;
        }
        else {
            return crossingSubArraySubArray;
        }
    }

    //跨越中间的最大子数组
    public SubArray findCrossingMaxSumSubArray(int[] array,int low,int mid,int high){
        SubArray[] leftSubArray = new SubArray[mid - low + 1];
        SubArray[] rightSubArray = new SubArray[high - mid];

        SubArray leftMaxSubArray = new SubArray();
        SubArray rightMaxSubArray = new SubArray();
        SubArray crossingMaxSubArray = new SubArray();


        for(int i = mid;i >= low;i--){
            if(i == mid) {
                leftSubArray[mid - i] = new SubArray(i, mid, array[i]);
            }
            else {
                int leftlow = i;
                int lefthigh = mid;
                int leftsum = leftSubArray[mid - i - 1].getSum() + array[i];
                leftSubArray[mid - i] = new SubArray(leftlow, lefthigh, leftsum);
            }
        }

        for(SubArray leftSubArraySubArray :leftSubArray){
            if(leftSubArraySubArray.getSum() > leftMaxSubArray.getSum()){
                leftMaxSubArray = leftSubArraySubArray;
            }
        }

        for(int i = mid + 1;i <= high;i++){
            if(i == mid + 1) {
                rightSubArray[i - mid - 1] = new SubArray(mid + 1, i, array[i]);
            }
            else{
                int rightlow = mid + 1;
                int righthigh = i;
                int rightsum = rightSubArray[i - mid - 2].getSum() + array[i];
                rightSubArray[i - mid - 1] = new SubArray(rightlow, righthigh, rightsum);
            }
        }

        for(SubArray rightSubArraySubArray :rightSubArray){
            if(rightSubArraySubArray.getSum() > rightMaxSubArray.getSum()){
                rightMaxSubArray = rightSubArraySubArray;
            }
        }

        crossingMaxSubArray.setLow(leftMaxSubArray.getLow());
        crossingMaxSubArray.setHigh(rightMaxSubArray.getHigh());
        crossingMaxSubArray.setSum(leftMaxSubArray.getSum() + rightMaxSubArray.getSum());

        return crossingMaxSubArray;
    }

    //暴力求解
    public SubArray maximumSumArrayViolent(){
        SubArray subArraySubArray = new SubArray();
        SubArray[][] sumSumArray = new SubArray[array.length][array.length];

        for(int i = 0;i < array.length;i++){
            for(int j = 0; j < array.length;j++){
                sumSumArray[i][j] = new SubArray(i,j,0);
            }
        }

        for(int i = 0;i < array.length;i++){
            for(int j = i;j < array.length;j++){
                if(j > i) {
                    int thelow = i;
                    int thehigh = j;
                    int thesum = sumSumArray[i][j - 1].getSum() + array[j];
                    sumSumArray[i][j] = new SubArray(thelow, thehigh, thesum);
                }
                else{
                    sumSumArray[i][j] = new SubArray(i,j,array[j]);
                }
            }
        }

        for(int i = 0;i < array.length;i++){
            for(int j = 0;j < array.length;j++){
                if(sumSumArray[i][j].getSum() > subArraySubArray.getSum()){
                    subArraySubArray = sumSumArray[i][j];
                }
            }
        }

        return subArraySubArray;
    }

    public SubArray theThirdWayOfSubArray(){
        SubArray maxSumSubArray = new SubArray();
        SubArray maxSumSubArrayJ = new SubArray();

        for(int j = 0;j < array.length - 1;j++){
            if(j == 0){
                maxSumSubArray = new SubArray(0,0,array[0]);
            }
            else{
                SubArray[] sumSubArray = new SubArray[j + 1];
                for(int i = j;i >= 0;i--){
                   if(i == j){
                       sumSubArray[j - i] = new SubArray(i,i,array[i]);
                   }
                    else{
                       int thelow = i;
                       int thehigh = j;
                       int thesum = sumSubArray[j - i - 1].getSum() + array[i];
                       sumSubArray[j - i] = new SubArray(thelow,thehigh,thesum);
                   }
                }

                for(int i = 0;i < j + 1;i++){
                    if(sumSubArray[i].getSum() > maxSumSubArray.getSum()){
                        maxSumSubArray.copy(sumSubArray[i]);
                    }
                }

                if(maxSumSubArray.getSum() > maxSumSubArrayJ.getSum()){
                    maxSumSubArrayJ.copy(maxSumSubArray);
                }
            }
        }

        return maxSumSubArrayJ;

    }

}
