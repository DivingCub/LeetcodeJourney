class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int len = position.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) ->{
                return b[0] - a[0];
            }
        );

        for(int i=0; i<len;i++){
            pq.offer(new int[]{position[i],speed[i]});
        }


        int count =0;
        int pos = -1;
        int spe = -1;

        while(!pq.isEmpty()){

            int[] cur = pq.poll();

            if(pos == -1){
                pos = cur[0];
                spe = cur[1];
                count++;
                continue;
            }

            double preTime = (double) (target - pos)/ spe ;
            double curTime =  (double)(target - cur[0])/ cur[1];

            if(preTime >= curTime) continue;

            pos = cur[0];
            spe = cur[1];
            count++;
        
        }
        
        return count;
        
    }
}

//Leetcode 853 题目和最终类型的探讨 巧用Map来完成
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int len = speed.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<len;i++){
            map.put(position[i],speed[i]);
        }

        Arrays.sort(position);

        int[] newPosition = new int[len];

        for(int i=0;i<len;i++){
            newPosition[i] = position[len-i-1];
            speed[i] = map.get(newPosition[i]);
        }


        int pos = newPosition[0];
        int spe = speed[0];
        int count = 1;

        for(int i=1;i<len;i++){

            double cur = (double) (target - newPosition[i])/ speed[i];
            double pre = (double) (target- pos)/spe;

            if(pre>=cur) continue;

            count++;
            pos = newPosition[i];
            spe = speed[i];
        }
        
            return count;
        
    }
}

