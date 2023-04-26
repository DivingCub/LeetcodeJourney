class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int len = gas.length;

       
        int index = -1;
     
        for(int i=0;i<len;i++){

            
            int remaining = gas[i];
            index = i;

            while(remaining >= cost[index]){

                remaining =remaining - cost[index % len] + gas[(index+1) % len];
                index = (index +1) % len;

                if(index == i){

                    return i;
                }


            }

            if(index < i){
                return -1;
            }

            i = index;
        
        }  

        return -1;

    }
}