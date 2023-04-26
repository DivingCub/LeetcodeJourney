class MinStack {

    Deque<Integer> dq;
    Deque<Integer> minDq;
    int check;
 
    public MinStack() {
        this.dq = new ArrayDeque<>();
        this.minDq = new ArrayDeque<>();
       
    }
    
    public void push(int val) {

        if(dq.isEmpty()||val<=minDq.peekLast()){
                minDq.addLast(val);
        }else{
                minDq.addLast(minDq.peekLast());
        }
        dq.offerLast(val);
    
    }
    
    public void pop() {

       dq.pollLast();
       minDq.pollLast(); 

    }
    
    public int top() {

        return dq.peekLast();        
    }
    
    public int getMin() {
        
       return minDq.peekLast();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */