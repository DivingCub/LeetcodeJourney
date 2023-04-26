class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        return helper(nums,0,len-1); 
    }

    private TreeNode helper(int[] nums,int lef,int rig){

        if(lef>rig){
            return  null;
        }

        if(lef==rig){
            return new TreeNode(nums[lef]);
        }

        int mid = lef + (rig-lef)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums,lef,mid-1);
        root.right = helper(nums,mid+1,rig);


        return root;

    }

}