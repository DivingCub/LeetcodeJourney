class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
    int maxVal = piles[0];

    for(int x:piles){
        maxVal = Math.max(maxVal,x);
    }

    int low = 1;
    int fast = maxVal;


     while(low<fast){

        int mid = low + (fast - low)/2;

        if(checkPoint(piles,mid)>h){
            low = mid+1;
        }else{
            fast = mid;
        }
     }   
 
        return low;
}

     private int checkPoint(int[]datas, int speed){

        int sum =0;

        for(int x:datas){
            sum += (x+speed-1)/speed;
        }

        return sum;
    }

}

//这题的难点在于确定一下上下的边界，吃的最快的情况，就是每个桶里面最大的那个值，就能保证每个桶基本上一次性就能够吃完，最慢就是一次吃一个，这样速度确定是最慢的