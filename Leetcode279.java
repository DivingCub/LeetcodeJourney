

// DFS 的使用方法

class Solution {
    public int numSquares(int n) {

        return helper(n,new HashMap<Integer,Integer>());
     
}

     public int helper(int n, HashMap<Integer,Integer> map){

         if(map.containsKey(n)){
             return map.get(n);
         }


        if(n==0){
            return 0;
        }

        int count = Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++){

            count = Math.min(count, helper(n-i*i,map)+1);

        }

        map.put(n,count);

        return count;

     }

}   
//利用 DP的做法来使用的时候

class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0]=0;
        dp[1]=1;

        for(int i=1;i<=n;i++){

            for(int j=1;j*j<=i;j++){


                dp[i] = Math.min(dp[i],dp[i-j*j] +1);

            }
        }

        return dp[n];
     }

}   
//利用 BFS来做的情况
