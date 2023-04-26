class Solution {
    public int strStr(String haystack, String needle) {

        char check = needle.charAt(0);

        int len = haystack.length();
        int index =Integer.MAX_VALUE;

        // if(haystack.equals(needle)) return 0;

        for(int i=0;i<len;i++){

            if(haystack.charAt(i) == check) {

                if( i+needle.length() <= haystack.length()  && haystack.substring(i,i+needle.length()).equals(needle)) index = Math.min(index,i);

            }


        }
        
        if(index ==Integer.MAX_VALUE){
            return -1;
        }else{
            return index;
        }
        
    }
}