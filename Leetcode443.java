class Solution {

    public int compress(char[] chars) {

        int len = chars.length;

        int index = 0;
        int write = 0;

        while(index<chars.length){

            char tem = chars[index];
            int  marker = index;

            while(index<chars.length && chars[index] == tem) index++;

            int lenTem =  index -marker;
            chars[write++] = chars[marker];
            
            if(lenTem > 1){

                for(char x: Integer.toString(lenTem).toCharArray()){

                        chars[write++] = x;

                }

            }
            
        }

      
        return write;     
    }

}