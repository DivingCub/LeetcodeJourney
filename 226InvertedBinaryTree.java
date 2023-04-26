//DFS 的使用方式
class Solution {
    public TreeNode invertTree(TreeNode root) {

        //这种需要再自己内部，不断便来变去的题目，最好还是利用自身迭代的方式来进行。
        
        if(root ==null) return null;

        swapTree(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void swapTree(TreeNode root){
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
    
    }
}

// BFS
class Solution {
    public TreeNode invertTree(TreeNode root) {

        //这种需要再自己内部，不断便来变去的题目，最好还是利用自身迭代的方式来进行。
        if(root == null) return null;

        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.offer(root);

        while(!dq.isEmpty()){

            int size = dq.size();

            while(size>0){

                TreeNode tem = dq.poll();

                swapTree(tem);

                if(tem.left!=null) dq.add(tem.left);
                if(tem.right!=null) dq.add(tem.right);

                
                size--;

            }


        }

        return root;

    }
    private void swapTree(TreeNode root){
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;   
    }

}