//直接利用 list的 特性来做，list.get.get
class Solution {
    public List<List<Integer>> generate(int numRows) {

        if(numRows ==0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();


        for(int i=0;i<numRows;i++){
            List<Integer> tem = new ArrayList<>();
            for(int j=0;j<=i;j++){

                if(j==0 || i==j){
                    tem.add(1);
                }else{
                    tem.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(new ArrayList(tem));
        }

        return res;
    }
}

//利用dp的数组来做的时候，做法：
class Solution {
    public List<List<Integer>> generate(int numRows) {

        if(numRows ==0) return new ArrayList<>();

        int[][] dp = new int[numRows][numRows];

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<numRows;i++){

             List<Integer> tem = new ArrayList<>();

            for(int j=0;j<=i;j++){

                if(j==0 || i==j){
                    dp[i][j]=1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }

                tem.add(dp[i][j]);
            }

             res.add(new ArrayList<>(tem));
        }
        
        return res;
        
    }
}
