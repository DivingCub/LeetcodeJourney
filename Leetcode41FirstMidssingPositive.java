class Solution {
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for(int i=0;i<len;i++){

            while(nums[i]>0 && nums[i]<=len && nums[nums[i]-1]!= nums[i]){
                    swap(nums,nums[i]-1,i);
            }

        }

        for(int i=0; i<len ; i++){

            if(nums[i]!= i+1){
                return i+1;
            }

        }
        
        return len+1;
}
       
   private void swap(int[] nums,int index1, int index2){


        int tem = nums[index1];
        nums[index1]= nums[index2];
        nums[index2] = tem;

}

}
