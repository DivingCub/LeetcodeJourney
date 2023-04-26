//用list 数组来做

class Solution {
    public void reorderList(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        //list 比数组好的地方在于，list的长度可以不固定，直接往里面加
        ListNode h = head;
        
        while(h!=null){
            list.add(h);
            h = h.next;
        }


        ListNode pre = null;

        for(int l=0,  r= list.size()-1;l<=r;l++,r--){

            if(l==r){
                list.get(l).next = null;
                //最后的结尾很重要
            }
            
            if(l!=0){
                pre.next = list.get(l);
                //pre看做完成上一次拼接的尾巴，还是要接下去
            }

            list.get(l).next = list.get(r);
            pre = list.get(r);
            pre.next = null;



        }
        
        
        
    }
}


//利用反转链表来做

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
    public void reorderList(ListNode head) {

      ListNode slow = head;
      ListNode fast = head;

      while(fast.next!=null && fast.next.next !=null){

          slow = slow.next;
          fast = fast.next.next;
      }
      

      ListNode second = slow.next;

      slow.next = null;

      ListNode first = head;

      second = helper(second);

      while(second!=null){

          ListNode curLef = first.next;
          first.next = second;
          first = curLef;

          ListNode curRig = second.next;
          second.next = first;
          second = curRig;
      }

      
        
    }

    private ListNode helper(ListNode tem){

        if(tem == null){
            return tem;
        }

        ListNode pre = null;
        ListNode cur = tem;

        while(cur!=null){

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;


    }


}

//参考的解法： https://leetcode.cn/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/