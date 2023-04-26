//时间复杂度就是  n * n!

//这里十分tricky的点就是 res.add(new ArrayList<>(path)); 如果

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(res,path,nums,nums.length,0);
        return res;
    }

    private void helper(List<List<Integer>> res,List<Integer> path,int[] nums,int len,int k){

        if(k==len){
            res.add(new ArrayList<>(path));
            return;  
        }


       for(int j =0;j<len;j++){

           int tem = nums[j];

           if(tem != 99){
               
               path.add(tem);
               nums[j] =99;     
               helper(res,path,nums,len,k+1);
               path.remove(path.size()-1);
               nums[j] = tem;
               
           }else{

               continue;

           }
       }
        } 
    }

