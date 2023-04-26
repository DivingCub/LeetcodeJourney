class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] tem = new int[]{1,2,3,4,5,6,7,8,9};

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(res,path,tem,k,0,n,0,0);
         
        return res;
        
    }

    private void helper(List<List<Integer>> res,List<Integer> path,int[] tem,int k,int len,int n,int sum,int index){

        if(len>k) return;

        if(len == k && n == sum ){
            res.add(new ArrayList<>(path));
            return;
        }


        for(int i=index; i<tem.length;i++){

            if(sum + tem[i] > n) continue;
            path.add(tem[i]);
            helper(res,path,tem,k,len+1,n,sum+tem[i],i+1);
            //这里不允许重复就是i+1， 允许重复就是i
            path.remove(path.size()-1);

        }
    }
}