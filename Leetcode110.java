class Solution {
    public boolean isBalanced(TreeNode root) {

        return helper(root)!= -1;
    }

    private int helper(TreeNode cur){

        if(cur ==null) return 0;

        int lef = helper(cur.left);
        if(lef == -1) return -1;
        int rig = helper(cur.right);
        if(rig == -1) return  -1;
        
        return Math.abs(lef-rig)<=1? Math.max(lef,rig)+1: -1;

    }

}