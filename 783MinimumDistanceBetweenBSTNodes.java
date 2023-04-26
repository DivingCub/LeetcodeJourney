//中序遍历，中序遍历

class Solution {
    public int minDiffInBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        int pre = list.get(0);
        int len = list.size();
        int min = Integer.MAX_VALUE;

        for(int i=1;i<len;i++){
            
            if(list.get(i)- pre < min){
                min = list.get(i) - pre;
            }

            pre = list.get(i);

        }

        return min;
    }

    private void dfs(TreeNode root,List list){
        if(root == null){
            return ;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}

//无擦别放入list之中，
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
    public int minDiffInBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> d = new ArrayDeque<>();

        d.addLast(root);

        while(d.size()>0){

            TreeNode poll = d.pollFirst();
            list.add(poll.val);

            if(poll.left !=null) d.addLast(poll.left);
            if(poll.right != null) d.addLast(poll.right);
        }

        Collections.sort(list);

        int n = list.size();
        int ans = Integer.MAX_VALUE;

        for(int i=1 ;i<n ;i++){
            int cur = Math.abs(list.get(i)- list.get(i-1));
            ans = Math.min(ans,cur);
        }
        

        return ans;

    }
}