
class Solution {

    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n= inorder.length;
        
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        return helper(inorder,0,n-1,postorder,0,n-1);
    }

    private TreeNode helper(int[] inorder,int inS, int inE, int[] postorder,int poS,int poE){

        if(poS> poE) return null;

        int midValue = postorder[poE];
        int midIndex = map.get(midValue);

        TreeNode root = new TreeNode(midValue);

        root.left = helper(inorder,inS,midIndex-1,postorder,poS,poS+midIndex-1-inS);
        root.right = helper(inorder,midIndex+1,inE,postorder,poS+midIndex-inS,poE-1);

        return root;
    }


}