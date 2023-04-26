class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Deque<TreeNode> dq = new ArrayDeque<>();

        if(root ==null && subRoot ==null) return true;

        dq.addLast(root);

        boolean flag = false;

        while(!dq.isEmpty()){

            int size = dq.size();

            for(int i=0;i<size;i++){

                TreeNode cur = dq.pollLast();

                if(cur.val == subRoot.val){

                    flag = isSameTree(cur,subRoot);

                    if(flag){
                        return true;
                    }

                }

                if(cur.left !=null) dq.addLast(cur.left);
                if(cur.right !=null) dq.addLast(cur.right);

            }
        }

        return flag;
    }


    private boolean isSameTree(TreeNode a, TreeNode b){

        if( a==null &&  b==null) return true;

        if( a==null || b==null) return false;

        if( a.val != b.val) return false;

        return isSameTree(a.left,b.left) && isSameTree(a.right,b.right);
    }



}

//