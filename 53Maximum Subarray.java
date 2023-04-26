class Solution {
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;

        for(int i=1;i<len;i++){

            if(dp[i-1]<0){
                dp[i] = nums[i];
            }else{
                dp[i] = nums[i]+ dp[i-1];
            }

            if(dp[i]> max) max= dp[i];
        }

        // if(dp[0]> max){
        //     return dp[0];
        // }else{
        //     return max;        }

        max = Math.max(max,dp[0]);

        return max;
        
    }
}