//一定会超时，进行完成。
class Solution {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {

       //dfs的做法
       
        helper(coins,amount,0);
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private void helper(int[] nums, int amount, int count){


        if(amount<0){
            return ;
        }

        if(amount ==0){
            res = Math.min(res,count);
        }

        for(int i=0;i<nums.length;i++){

            helper(nums,amount-nums[i],count+1);
        }

    }
}

//递归 加上 dp的思维去做的，非常好
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {

       if(coins.length ==0) return -1;

       memo = new int[amount];

        return findWay(coins,amount);

    }


    private int findWay(int[]coins, int amount){

        if(amount<0)return -1;
        if(amount ==0) return 0;
        if(memo[amount-1]!=0) return memo[amount-1];

        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){

            int res = findWay(coins,amount - coins[i]);

            if(res>=0 && res<min){
                min = res +1;
            }

        }
        memo[amount-1] = (min == Integer.MAX_VALUE?-1:min);

        return  memo[amount-1];
    }

}