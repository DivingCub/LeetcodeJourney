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
    public boolean isCompleteTree(TreeNode root) {

        if(root == null){
            return true;
        }

        boolean nullNodeFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            TreeNode cur = q.poll();

            if(cur == null){
                nullNodeFound = true;
            }else{
                
                if(nullNodeFound){
                    return false;
                }

                q.offer(cur.left);
                q.offer(cur.right);        

            }


// 遇到了条件，可以先用flag 存着，如果第二次遇到，或者不该出现的地方，判断这个flag，一旦flag是真的，那么就是有问题的

        }
        
        return true;

    }
}