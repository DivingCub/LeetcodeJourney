//本题有点意思， for循环里面，距离的限制就是一个最长距离的， 最长距离还可以是动态更改的，头一次遇见，有点意思，有点意思
// Almost done 差一点点，

class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length ==1){
            return true;
            }

        int[] reachAble = new int[nums.length];

        int max = 0;
        int index = 0;
        for(;index<=max;index++){

            reachAble[index] = index + nums[index];

            max = Math.max(max,reachAble[index]);

            if(max >= nums.length-1){
            return true;}
           
        }
         
        return false;

    }
}

//使用贪心算法来进行运算的时候

class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length ==1){
            return true;
            }

        if(nums[0]==0){
            return false;
        }

        int[] dp  = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length-1; i++){

            dp[i] = Math.max(dp[i-1],nums[i]+i);

            if(dp[i]==i){
                return false;
            }
        }
        return true;
    }
}