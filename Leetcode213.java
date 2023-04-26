class Solution {
    public int rob(int[] nums) {
        

    int len = nums.length;

    if(len ==1) return nums[0];

    int len2 = len-1;

    int[] tem = new int[len2];

    for(int i=0;i<len-1;i++){
        tem[i] = nums[i];
    }

    int a = robHelper(tem);

    for(int i=1;i<len;i++){
        tem[i-1] = nums[i];
    }

    int b = robHelper(tem);

    return Math.max(a,b);

    }

    public int robHelper(int[] nums) {
        int len = nums.length;

        if(len==0) return 0;

        int[] dp = new int[len+1];

        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i=2;i<=len;i++){

            dp[i] = Math.max(dp[i-1],nums[i-1]+dp[i-2]);

        }
        
        return dp[len];
    }
}