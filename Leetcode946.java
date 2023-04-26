class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0 , j=0;i<pushed.length;i++){

            dq.offerLast(pushed[i]);

            while(!dq.isEmpty() && dq.peekLast()== popped[j]){
                dq.pollLast();
                j++;
            }
        }
        return dq.isEmpty()? true : false;
    }
}

//就想着正确的操作逻辑是什么，把正确的顺序敲下来，如果跑不起来，换成跑步起来的结果，其等效于什么，