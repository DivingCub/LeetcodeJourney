//有关中序遍历如何去解决情况

class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        if(root ==null) return true;

        if(!isValidBST(root.left)) return false;

        if(root.val <= pre) return false;

        pre = root.val;

        return isValidBST(root.right) ;

    }
}


//利用遍历完成的情况
class Solution {
    public boolean isValidBST(TreeNode root) {

        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;

        return helper(root,max,min);
    }

    private boolean helper(TreeNode cur,long max,long min){

        if(cur == null) return true;

        if(cur.val <= min || cur.val >= max) return false;

        return helper(cur.left, cur.val, min) && helper(cur.right,max,cur.val);

    }
}