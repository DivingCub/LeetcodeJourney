class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (x1,x2) ->{
                return x1 - x2;
            }
        );


        for(int num: nums){

            if(pq.size()<k){

                pq.offer(num);

            }else{

                if(num> pq.peek()){

                    pq.offer(num);
                    pq.poll();

                }

            }

        }
        
        return pq.peek();
    }
}