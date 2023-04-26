// to upper case

class Solution {
    public boolean isPalindrome(String s) {

        StringBuffer sgood = new StringBuffer();

        int length = s.length();

        for(int i=0;i<length;i++){

            char tem = s.charAt(i);

            if(Character.isLetterOrDigit(tem)){
                sgood.append(Character.toLowerCase(tem));
            }

        }

        int l = 0;
        int len2 = sgood.length();
        int r = len2-1;

        while(l<=r){
            
            if(
                
        Character.toLowerCase(sgood.charAt(l))!= 
        Character.toLowerCase(sgood.charAt(r))){
                return false;
            }

            l++;
            r--;
        }
        
        return true;
        
    }
}

//另一种写法：
class Solution {
    public boolean isPalindrome(String s) {

        StringBuffer sgood = new StringBuffer();

        int length = s.length();

        for(int i=0;i<length;i++){

            char x = s.charAt(i);

            if(x >= 'A' && x<='Z'){
                sgood.append(Character.toLowerCase(x));
            }else if(x >= 'a' && x<='z'){
                sgood.append(x);
            }else if(x >= '0' && x<='9'){
                sgood.append(x);
            }else{
                continue;
            }
        }

        int l = 0;
        int r = sgood.length()-1;

        while(l<=r){

            if(sgood.charAt(l) != sgood.charAt(r)){
                    return false;
            }
            l++;
            r--;
            }

           return true; 
        }
        
        
    }