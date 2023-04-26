//BFS的做法，直接逐级的将东西弄出去，DFS的做法太复杂了，不建议那么做。
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer>  inDegree = new HashMap<>();
        Map<Integer,List<Integer>>  affectedMap = new HashMap();
        int[] res = new int[numCourses];     
        for(int i=0;i<numCourses;i++){
            inDegree.put(i,0);
        }

        for(int[] input : prerequisites){
            int affected = input[0];
            int preCon = input[1];
            inDegree.put(affected,inDegree.get(affected)+1);
            if(!affectedMap.containsKey(preCon)){
                affectedMap.put(preCon, new ArrayList<Integer>());
            }
            affectedMap.get(preCon).add(affected);
        }

        Deque<Integer> outD = new ArrayDeque<>();
        for(int key : inDegree.keySet()){
            if(inDegree.get(key)==0){
                outD.offer(key);
            }
        }
        int index =0;
        while(!outD.isEmpty()){

            int cur = outD.poll();
            res[index++] = cur;

            if(!affectedMap.containsKey(cur)){
                continue;
            }else{

            List<Integer> tem = affectedMap.get(cur);

            for(int i=0;i<tem.size();i++){
                int key = tem.get(i);
                inDegree.put(key,inDegree.get(key)-1);
                if(inDegree.get(key)==0){
                    outD.offer(key);
                }
            }
            }
          }
        if(index == numCourses) return res;
        return new int[0];
       
    }
}