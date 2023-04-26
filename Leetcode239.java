//先不管如何都往里面加入，后面再根据条件逐渐将不同，不符合情况的解完全给抛出
// 两个while 一个if 一定要记清楚了
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> tem = new ArrayDeque<>(k);
        int[] res = new int[nums.length-k+1];


        int l = 0;
        int r = 0;

        for(;r<nums.length; r++){

            int index = r;

            while(!tem.isEmpty()&& nums[r] >= nums[tem.peekFirst()] ) tem.pollFirst();
            tem.addFirst(r);

            while(tem.peekLast()<r-k+1){
                    tem.pollLast();
                }

            
            if(r-k+1>=0){
                res[l] = nums[tem.peekLast()];
                l++;
            }
         
            
        }
        
     return res;
        
    }
}