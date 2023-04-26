class Solution {

    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Map<Node,Node> map = new HashMap<>();

        Node cur = head;

        while(cur!=null){
            Node tem = new Node(cur.val);
            map.put(cur,tem);
            cur = cur.next;
        }

        cur = head;

        while(cur!=null){

            Node newNode = map.get(cur);

            if(cur.next!=null){
                newNode.next = map.get(cur.next);
            }

            if(cur.random!=null){
                newNode.random = map.get(cur.random);
            }

            cur = cur.next;
        }

        return map.get(head);


        
    }
}