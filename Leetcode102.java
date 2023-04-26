class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return new ArrayList<>();

        dq.addLast(root);

        while(!dq.isEmpty()){

           int len =  dq.size() ;

            for(int i=0;i<len;i++){

                TreeNode cur = dq.poll();
                path.add(cur.val);
                if(cur.left !=null) dq.add(cur.left);
                if(cur.right!=null) dq.add(cur.right);
                 
            }

            res.add(new ArrayList<>(path));
            path = new ArrayList<>();
        }


        return res;
        
    }
}