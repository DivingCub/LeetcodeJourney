class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> q = new ArrayDeque<>(k);

        int len = nums.length;
        int[] res = new int[len- k+1];

        int index = 0;

        for(int i=0;i<len;i++){

            while(!q.isEmpty()&& nums[i]> nums[q.peekLast()]){
                    q.pollLast();
            }

            q.addLast(i);

            while(q.peekFirst() < i-k+1){
                q.pollFirst();
            }


            if(i-k+1 >= 0){
                res[index] = nums[q.peekFirst()];
                index++;
            }

            //很明显，最前面放的才是最大的数，后面放的都是次大的数
        }

        return res;
        
    }
}