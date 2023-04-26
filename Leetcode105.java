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

    private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,len-1,inorder,0,len-1);

        
    }

    private TreeNode helper(int[] preorder,int preS,int preE ,int[] inorder, int inS, int inE){

        if(inS > inE || preS> preE) return null;

        int valueOfMid = preorder[preS];
        int midIndex = map.get(valueOfMid);

        TreeNode root = new TreeNode(valueOfMid);

        root.left = helper(preorder,preS+1,preS +midIndex-inS,inorder,inS,midIndex-1);
        root.right = helper(preorder,preS+1+ midIndex-inS,preE,inorder, midIndex+1,inE);
          
        return root;
    }


}