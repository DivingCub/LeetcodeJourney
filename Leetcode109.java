/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    

    public TreeNode sortedListToBST(ListNode head) {

       return helper(head,null);
        
    }

    private TreeNode helper(ListNode left,ListNode right){

        if(left == right) return null;

        ListNode mid = getMedian(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(left,mid);
        root.right = helper(mid.next,right);

        return root;
    }

    private ListNode getMedian(ListNode left,ListNode right){

        ListNode slow = left;
        ListNode fast = left;

        while(fast!= right && fast.next!=right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next; 
        }
        return slow;
    }
}