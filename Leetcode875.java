class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max =0;
        for(int x:piles) max = Math.max(max,x);


        int start = 1;
        int end =  max;

        

        while(start < end){

            int mid = start + (end - start)/2;

            if(check(mid,piles) >h){
                start = mid+1;
            }else{
                end = mid;
            }

        }

        return start;

    }

    private int check(int input,int[] piles){
            int timeCost = 0;
            for(int j :piles){
                timeCost += (j % input == 0 ? j/input :j/input + 1 );   
            }    
            return timeCost;
        }
    
}

//这题的难点在于确定一下上下的边界，吃的最快的情况，就是每个桶里面最大的那个值，就能保证每个桶基本上一次性就能够吃完，最慢就是一次吃一个，这样速度确定是最慢的