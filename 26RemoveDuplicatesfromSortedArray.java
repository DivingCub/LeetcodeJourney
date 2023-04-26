class Solution {
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if(len <=1) return len;

        int left = 0;
        int right = 1;

        while(right<=len-1){


            while(nums[left] == nums[right] && right<len-1) right++;
            nums[++left] = nums[right];

            right++;

        }
        
        if(nums[left] == nums[left-1]) return left;
        return left+1;

        
    }
}