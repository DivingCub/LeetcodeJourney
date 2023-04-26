//采用模拟来进行做题：
class Solution {

    private HashMap<Integer,ListNode> map;

    public Solution(ListNode head) {
        
        map = new HashMap<>();
    
        int index =0;
        while(head !=null){
            map.put(index++,head);
            head = head.next;
        }

    }
    
    public int getRandom() {
        

        return map.get( new Random().nextInt(map.size())).val;

    }
}

//采用ArrayList同样可以去走
class Solution {

   List<ListNode> list;

    public Solution(ListNode head) {
        
        list = new ArrayList<>();

        while(head!=null){
            list.add(head);
            head = head.next;
        }
       

    }
    
    public int getRandom() {
        return list.get(new Random().nextInt(list.size())).val;
    }
}
