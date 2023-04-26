//使用递归 （想明白 前点 和 后点 如何进行连接），两者什么关系进行作用

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }
        
        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list2.next,list1);
            return list2;
        }

    }
}




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
//选择迭代的方法来进行
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode prehead = new ListNode(-1);

        ListNode travel = prehead;

        while(list1 !=null && list2!=null){

            if(list1.val > list2.val){

                travel.next = list2;
                list2 = list2.next;
                travel= travel.next;

            }else{

                 travel.next = list1;
                list1 = list1.next;
                travel= travel.next;
            }


        }

        //记住这里是next，不是其他的内容
        travel.next = list1 == null ? list2:list1;

    
        return prehead.next;

        
    }
}