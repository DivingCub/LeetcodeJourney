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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return new ArrayList<>();
        Deque<TreeNode> tem = new ArrayDeque<>();

        tem.offer(root);
        int layer =1;

        while(!tem.isEmpty()){

            int size = tem.size();
            List<Integer> listTem = new ArrayList<>();

            while(size >0){

                TreeNode curNode = tem.poll();

                listTem.add(curNode.val);
                
                if(curNode.left !=null) tem.add(curNode.left);
                if(curNode.right !=null) tem.add(curNode.right);

                size--;

            }
            if(layer % 2 ==1){ 
                res.add(listTem);}
            else{
                Collections.reverse(listTem);
                res.add(listTem);
            }       
            layer++;
        }
           
      return res;
        
    }
}