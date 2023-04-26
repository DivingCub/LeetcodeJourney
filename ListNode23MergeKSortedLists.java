//利用 大根堆 和 小根堆的 PriorityQueue的 东西
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;

        

        ListNode gather = new ListNode(-1);
        ListNode cur = gather;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x1,x2)->{
            return x1-x2;
        });


        for(int i=0;i<len;i++){
            
            ListNode head = lists[i];
            
            while(head!=null){
                pq.offer(head.val);
                head = head.next;
            }

        }

        while(pq.size()>0){

            ListNode tem = new ListNode(pq.poll());

            cur.next = tem;

            cur = cur.next;

        }


        return gather.next;
        
    }
}
// 分治，分治 这样的处理关系

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists ==null || lists.length ==0) return null;

        return merge(lists,0,lists.length-1);
        
    }

    private ListNode merge(ListNode[] lists,int m,int n){

        if(m==n) return lists[m];
        int mid = m + (n-m)/2;
        ListNode left  = merge(lists,m,mid);
        //注意一定是 mid+1 开始来完成其中，而不是直接是mid
        ListNode right = merge(lists,mid+1,n);
        return mergeTwo(left,right);
    }


    private ListNode mergeTwo(ListNode left, ListNode right){

        if(left ==null) return right;
        if(right ==null) return left;

        if(left.val < right.val){
            left.next = mergeTwo(left.next, right);
            return left;
        }else{
            right.next = mergeTwo(right.next, left);
            return right;
        }
    }

}