class Solution {
    public int findMin(int[] nums) {
        
        int lef = 0;
        int rig = nums.length -1;

        while(lef<rig){

            int mid = lef + (rig-lef)/2;

            if(nums[mid]>nums[rig]){
                lef = mid+1;
            }else{
                rig = mid;
            }
        }

        return nums[rig];
    }
}



