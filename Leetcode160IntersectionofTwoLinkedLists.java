public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode temA = headA;
        ListNode temB = headB;

        
        while(temA != temB){


            temA = temA == null ? headB : temA.next ;
            temB = temB == null ? headA : temB.next;

            
        }

        return temA;

    }
}