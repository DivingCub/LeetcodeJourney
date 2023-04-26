class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //inDegree
        //ListM


        Map<Integer,Integer> inDegree = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            inDegree.put(i,0);
        }
        Map<Integer,List<Integer>> listM = new HashMap<>();

        for(int[] tem :prerequisites){
            int affected = tem[0] ; //next;
            int preCon = tem[1];  //cur

            inDegree.put(affected,inDegree.get(affected)+1);


            if(!listM.containsKey(preCon)){
                listM.put(preCon,new ArrayList<>());
            }
            listM.get(preCon).add(affected);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int key : inDegree.keySet()){

            if(inDegree.get(key)==0){
                queue.offer(key);
            }

        }

        while(!queue.isEmpty()){

            int take = queue.poll();

            if(!listM.containsKey(take)){
                continue;
            }

            List<Integer> afflist = listM.get(take);
            

            for(int i=0;i<afflist.size();i++){
                inDegree.put(afflist.get(i),inDegree.get(afflist.get(i)) -1 );

                if(inDegree.get(afflist.get(i))==0){
                    queue.offer(afflist.get(i));
                }

            }
        }
        
        for(int key: inDegree.keySet()){

            if(inDegree.get(key)!=0){
                return false;
            }

        }       
        return true;     
    }
}