class Node{
    int key,val;
    Node left,right;
    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}


class LRUCache {

    Map<Integer,Node> hashmap = new HashMap<>();
    Node L,R;
    int n;

    public LRUCache(int capacity) {
        n = capacity;
        L = new Node(-1,-1);
        R = new Node(-1,-1);
        L.right =R;
        R.left = L;

    }
    
    public int get(int key) {
        if(!hashmap.containsKey(key)) return -1;

        Node p = hashmap.get(key);

        remove(p);
        insert(p);

        return p.val;

    }
    
    public void put(int key, int value) {
        if(hashmap.containsKey(key)){

            Node p = hashmap.get(key);
            p.val = value;//更新值
            remove(p);
            insert(p);
        }else{
            if(hashmap.size()==n){
                Node p = R.left;
                remove(p);
                hashmap.remove(p.key);
            }
            Node p = new Node(key,value);
            insert(p);
            hashmap.put(key,p);
        }
    }


    public void remove(Node p){

        p.right.left = p.left;
        p.left.right = p.right;

    }


    public void insert(Node p){
        
        p.left = L;
        p.right =L.right;
        L.right.left = p;
        L.right = p;
        
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */