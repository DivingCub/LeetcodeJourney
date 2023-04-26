class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1,o2) ->  {
                return o2 - o1;
            }
        );


        for(int x:stones){
            pq.add(x);
        }


        while(pq.size()>=2){
            int numOne = pq.poll();
            int numTwo = pq.poll();
            int comb = numOne - numTwo;
            if(comb==0)continue;
            pq.add(comb);
        }


        return pq.size()==0? 0:pq.peek();

    }
}