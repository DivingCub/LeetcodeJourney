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
//优先队列的实现方式
class Solution {
    public ListNode sortList(ListNode head) {


        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (x1,x2) ->{
                return x1 - x2;
            }
        );
        while(head!=null){

            pq.offer(head.val);
            head = head.next;

        }
        ListNode head2 = new ListNode(-1);
        ListNode cur = head2;

        while(pq.size()>0){

            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        return head2.next;     
    }
}

//排序，分治分办法
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
class Solution {
    public ListNode sortList(ListNode head) {

        if(head ==null){
            return null;
        }

        return mergeSort(head);

    }

    private ListNode mergeSort(ListNode head){

        if(head ==null || head.next ==null ) return head;

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next !=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = mergeSort(slow.next);
        slow.next = null;
        ListNode left = mergeSort(head);

        return merge(left,right);
    }

    

    private ListNode merge(ListNode left, ListNode right){

        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;

        while(left != null && right!=null) {

          if(left.val<=right.val){
              p.next = left;
              left = left.next;
          }else{
              p.next = right;
              right = right.next;
          }

            p = p.next;
        }

         if(left==null) p.next = right;
         if(right==null) p.next = left;


        return dummyhead.next;

    }

}


