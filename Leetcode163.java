class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<String>();

        
        if(nums.length ==0){

            if(upper == lower){
                res.add(String.valueOf(upper));
            }else{
                res.add(lower+ "->" + upper);     
            }
            return res;
        }

        int nums1 = nums[0];

        if(lower== nums[0]){
            
        }else if(lower==nums[0]-1){
            res.add(String.valueOf(lower));
        }else{
            int tem1 = lower;
            int tem2 = nums[0]-1;
            String sTem = tem1 + "->" + tem2;
            res.add(sTem);
        }

       int l = 0;
       int r = 1;


       while(l<r && r<nums.length){

           if(nums[r]-nums[l]==0){

           }else if(nums[r]-nums[l]==1){
               
           }else if(nums[r]-nums[l]==2){
               res.add(String.valueOf(nums[l]+1));
           }else{ 
                int tem1 = nums[l] +1;
                int tem2 = nums[r] -1;
                String sTem = tem1+ "->" + tem2;
                res.add(sTem);   
           }
           l++;
           r++;
           continue;
       } 
        

        int nums2 = nums[nums.length-1];

        if(upper== nums2){
            
        }else if(upper==nums2+1){
            res.add(String.valueOf(upper));
        }else{
            int tem1 = upper;
            int tem2 = nums2+1;
            String sTem = tem2 + "->" + tem1;
            res.add(sTem);
        }

       
    return res;

    }
}