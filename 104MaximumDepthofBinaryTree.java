//使用 BFS 来做

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }


        Deque<TreeNode> dq = new ArrayDeque<>();
        
        int res =0;
        dq.add(root);


        while(!dq.isEmpty()){

            int size = dq.size();

            while(size>0){

                TreeNode tem = dq.poll();

                if(tem.left !=null){
                    dq.add(tem.left);
                }

                if(tem.right != null){
                    dq.add(tem.right);
                }

                size--;

            }

            res++;
        }

    return res;
}
}


//使用 迭代的方式来做
class Solution {
    public int maxDepth(TreeNode root) {
        int res =0;
        res = helper(root,0);
        return res;
}


    private int helper(TreeNode root, int input){
        if(root ==null) return 0;
        int lef =0;
        int rig =0;
        if(root.left !=null){
            lef = helper(root.left,input+1);
        } 
        if(root.right!=null){
            rig = helper(root.right,input+1);
        }
        return Math.max(lef , rig) +1;
    }
}



