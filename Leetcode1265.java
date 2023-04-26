class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Deque<ImmutableListNode> dq=new ArrayDeque<>();    
        while(head!=null)
        {
            dq.addLast(head);
            head=head.getNext();
        }
        while(!dq.isEmpty())
        {
            dq.removeLast().printValue();
        }
    }
}