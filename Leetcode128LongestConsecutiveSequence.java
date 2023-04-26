class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set=  new HashSet<>();

        for(int n: nums){
         set.add(n);
        }


        int res =0;

        for(int x: set){

            if(!set.contains(x-1)){
                int y=x;
                while(set.contains(y+1)) y++;
                int tem = y-x +1;
                res = Math.max(tem,res);
            }
        }

        return res;
    }

}

//Hashset的神奇用法，真的很赞