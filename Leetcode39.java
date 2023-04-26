class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res  = new ArrayList<>();
        List<Integer> tem = new ArrayList<Integer>();
        Arrays.sort(candidates);

        helper(res,tem,candidates,target,0);

        return res;   
    }

    private void helper(List<List<Integer>>res,List<Integer> tem , int[] candidates, int curRemain, int index ){

        if(curRemain== 0){
            res.add(new ArrayList<>(tem));
            //这里很关键，不是 res.add(tem),外面还要套一个
            return;
        }

        for(int i=index; i<candidates.length;i++){

            if(curRemain - candidates[i] <0) break;

            tem.add(candidates[i]);
            helper(res,tem,candidates,curRemain-candidates[i],i);
            //这里下次循环的位置还是重要的，不然后面3可以走 3,2,2的路线则一定和前面重复了，最好的就是第一个把后面大部分情况走了， 然后就可以剪枝
            tem.remove(tem.size()-1);

        }


    }

// if(curRemain-x >=0){
//                 tem.add(x);
//                 helper(res,tem,candidates,curRemain-x);
//                 tem.remove(tem.size()-1);
//             }else{
//                 continue;
//             }

}