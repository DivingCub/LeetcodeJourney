class Solution {
    public int jump(int[] nums) {

    if(nums ==null|| nums.length<=1) return 0;


    int curMaxJump =0;
    int postMaxJump = 0;

    int step = 0;
    int i =0;

    while(i<nums.length-1){

        postMaxJump = Math.max(postMaxJump,nums[i] +i);

        if(i==curMaxJump){

            curMaxJump = postMaxJump;
            step++;

        }

        i++;
    }

        return step;
    }
}