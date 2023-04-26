class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int lef = 0;
        int rig = len -1;
        while(lef<rig){
            int mid = lef + (rig - lef)/2;

            if(mid%2==1){
                if(nums[mid]==nums[mid-1]) lef =mid+1;
                else rig = mid;
            }else{
                if(nums[mid]== nums[mid+1]) lef = mid+2;
                else rig =mid;
            }
        }
        return nums[lef];
}
}

//https://leetcode.cn/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-y8gh/