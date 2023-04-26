class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root ==null) return true;

        if(root.left ==null && root.right ==null) return true;

        if(root.left ==null || root.right ==null) return false;        

        return isSame(root.left,root.right);
        
    }

    private boolean isSame(TreeNode a, TreeNode b){

        if(a ==null && b== null) return true;

        if(a ==null || b==null ) return false;

        if(a.val != b.val) return false;

        return isSame(a.left,b.right) && isSame(a.right,b.left);
 
    }


}