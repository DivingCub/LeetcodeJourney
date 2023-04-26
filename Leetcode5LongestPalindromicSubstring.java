
Method1: 就是采用中心扩散，逐一考虑三种情况，左边移动，右边移动，两边移动
// array真的没有其他的方便，还是用s.chart(),outofbound 会比其他的友好很多

//因为while的特性，最后结束的时候，一定会多加一次或者多减一次，才跳出了循环，所以最后left 要+1一次

class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();

        if(len<2){
            return s;
        }

        char[] tem = s.toCharArray();
        

        int maxLeft = 0;
        int maxRight = 0;

        int maxLen = 1;
        int lenx = 1;


        for(int i=0;i<len;i++){

            int left = i-1;
            int right = i+1;

        

            while( left >=0 && s.charAt(i) == s.charAt(left) ){
                    maxLen++;
                    left--;
            }


            while( right<len  && s.charAt(i) == s.charAt(right) ){
                    maxLen++;
                    right++;
            }

            
            while(right<len && left >=0  && s.charAt(left) == s.charAt(right)  ){
                    maxLen = maxLen +2;
                    left--;
                    right++;
            }


            if(maxLen > lenx){

                lenx = maxLen;

                maxLeft = left;

            }
         
            maxLen =1;

        }

        return s.substring(maxLeft+1,maxLeft+lenx+1);

    }
}

Method2：使用dp，动态规划的过程：（动态规划非常有意思）

class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();

        if(len<2){
            return s;
        }

        char[] tem = s.toCharArray();
        boolean[][] check = new boolean[len][len];

        int maxLeft = 0;
        int maxRight = 0;

        int maxLen = 1;



        for(int k=0;k<len;k++){
            check[k][k] = true;
        }

        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){

                if(tem[i]!=tem[j]){
                    check[i][j]= false;
                }else{

                    if(j-i<=2){
                        check[i][j] = true;
                    }else{
                        check[i][j] = check[i+1][j-1];
                    }


                }

            if(check[i][j] && j-i+1 > maxLen){

                maxLen = j-i+1;
                maxLeft = i;
                maxRight = j;

            }


            }
        }

        return s.substring(maxLeft,maxLen+maxLeft);

    }
}




