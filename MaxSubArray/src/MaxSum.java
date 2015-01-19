/**
 * Created by Administrator on 2015/1/16.
 */
public class MaxSum {
    private int low = 0;
    private int high = 0;
    private int maxsum = 0;

    MaxSum(){

    }

    MaxSum(int low,int high,int maxsum){
        this.low = low;
        this.high = high;
        this.maxsum = maxsum;
    }

    public int getLow(){
        return low;
    }

    public int getHigh(){
        return high;
    }

    public int getMaxSum(){return maxsum;}

    public void setLow(int low){
        this.low = low;
    }

    public void setHigh(int high){
        this.high = high;
    }

    public void setMaxSum(int maxsum){
        this.maxsum = maxsum;
    }

}

