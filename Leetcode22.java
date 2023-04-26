class Solution {
    public List<String> generateParenthesis(int n) {

        StringBuffer sb = new StringBuffer();
        List<String> res = new ArrayList<>();

        helper(res,n,n,sb);
        return res;
    }

    private void helper(List<String> res,int left,int right,StringBuffer sb){

        if(left == 0 && right ==0){
            res.add(sb.toString());
            return;
        }

        //剪枝，left 》 right，说明 （ 更少，（更少就玩完了，一定要减掉
        if(left > right){
            return;
        }

        if(left >0){
            sb.append('(');
            helper(res,left-1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(right >0){
            sb.append(')');
            helper(res,left,right-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }



    }


}