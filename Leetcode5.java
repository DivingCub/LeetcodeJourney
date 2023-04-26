//因为while的特性，最后结束的时候，一定会多加一次或者多减一次，才跳出了循环，所以最后left 要+1一次

class Solution {
    public String longestPalindrome(String s) {
        
      if(s.length()==1) return s;

      int lef=0;
      int index =0;
      int rig =0;
      int res = 0;

      String str = s.substring(0,1);

      
      while(index<s.length()){

          lef = index;
          rig = index;

          while(lef-1>=0 && s.charAt(index)== s.charAt(lef-1)){
              lef--;
          }

          while(rig+1<s.length() && s.charAt(rig+1)==s.charAt(index)){
              rig++;
          }

          while(lef-1>=0 && rig+1<s.length() && s.charAt(lef-1) == s.charAt(rig+1)){
              rig++;
              lef--;
          }

          int len = rig - lef +1;
          
          if(len > res){
              res = Math.max(len,res);
              str = s.substring(lef,rig+1);
          }

          len =1;

          index++;
          
      }
    
        return str;
    }
}


//后面采用dp的做法来进行完善



class Solution {
    public String longestPalindrome(String s) {
        
      if(s.length()==1) return s;

      int maxLen = 1;
      int start = 0;

      int strLen = s.length();


      boolean[][] dp = new boolean[strLen][strLen];

      for(int i=0;i<strLen;i++){
          dp[i][i] = true;
      }

      char[] tem = s.toCharArray();


      for(int j=1;j<strLen;j++){

          for(int i=0;i<j;i++){

              if(tem[i]!= tem[j]){
                  dp[i][j] = false;
              }else{

                  if(j-i <=2){
                      dp[i][j] = true;
                  }else{
                      dp[i][j] = dp[i+1][j-1];
                  }

              }

              if( dp[i][j] &&j-i+1 > maxLen){
                        maxLen = j-i+1;
                        start = i;
                  }
          }
      }

        return s.substring(start,start+maxLen);
      
    }
}