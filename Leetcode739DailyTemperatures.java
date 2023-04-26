class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        

        int len = temperatures.length;

        

        if(temperatures==null || len <=1){
            return new int[]{0};
        }


        int[] res = new int[len];
        Deque<Integer> tem = new ArrayDeque<>();

        for(int i=0;i<len;i++){

        
        while(!tem.isEmpty() && temperatures[i] > temperatures[tem.peekLast()]){
            int index = tem.pollLast();
            res[index] = i-index;   
        }
        
         tem.add(i);
        }

        return res;
    }
}