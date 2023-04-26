

for(int i=0;i<len;i++){

    while(nums[i]>0 && nums[i]<=len && nums[nums[i]-1]!= nums[i]){
        swap(nums,nums[i]-1,i);
    }

}


private void swap(int[] nums,int index1, int index2){


        int tem = nums[index1];
        nums[index1]= nums[index2];
        nums[index2] = tem;

}