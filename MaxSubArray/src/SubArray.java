/**
 * Created by Administrator on 2015/1/16.
 */
public class SubArray {
    private int low = 0;
    private int high = 0;
    private int sum = 0;

    SubArray(){

    }

    SubArray(int low, int high, int sum){
        this.low = low;
        this.high = high;
        this.sum = sum;
    }

    public int getLow(){
        return low;
    }

    public int getHigh(){
        return high;
    }

    public int getSum(){
        return sum;
    }

    public void setLow(int low){
        this.low = low;
    }

    public void setHigh(int high){
        this.high = high;
    }

    public void setSum(int sum){
        this.sum = sum;
    }

    public void copy(SubArray subArray){
        this.low = subArray.getLow();
        this.high = subArray.getHigh();
        this.sum = subArray.getSum();
    }

}

