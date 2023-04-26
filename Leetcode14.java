class Solution {
    public String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        String ans = strs[0];

        if(len ==0) return "";

        int minLen = Integer.MAX_VALUE;

        for(String x : strs){
            minLen = Math.min(minLen,x.length());
        }

        for(int i=1;i<strs.length;i++){

            int j=0;
            for( ; j<minLen && j<ans.length();j++){

                if(strs[i].charAt(j)!= ans.charAt(j)){
                    break;
                }

            }
            ans = ans.substring(0,j);
            if(ans==""){
                return ans;
            }

        }
        
    return ans;
        
    }
}