class Solution {
    public int minReorder(int n, int[][] connections) {

        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int[] tem : connections){
            HashSet<Integer> set = map.containsKey(tem[0])? map.get(tem[0]) : new HashSet<>();
            set.add(tem[1]);
            map.put(tem[0],set);
            HashSet<Integer> setReverse = map.containsKey(tem[1])? map.get(tem[1]) : new HashSet<>();
            setReverse.add(tem[0]*-1);
            map.put(tem[1],setReverse); 
        }
        return helper(map,n);
    }


    private int helper(HashMap<Integer,HashSet<Integer>> map,int n){
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        
        int ans = 0;
        queue.addLast(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            for(int x: map.get(queue.pollFirst())){
                if(visited[Math.abs(x)]) continue;
                if(x >0) ans++;
                visited[Math.abs(x)] = true;
                queue.addLast(Math.abs(x));
            }
        }
        return ans;
    }
}