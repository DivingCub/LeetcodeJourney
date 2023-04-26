class Solution {
    public int romanToInt(String s) {


        Map<Character,Integer> tem = new HashMap<>();

        tem.put('I',1);
        tem.put('V',5);
        tem.put('X',10);
        tem.put('L',50);
        tem.put('C',100);
        tem.put('D',500);
        tem.put('M',1000);

        int len = s.length();

    
        int res = 0;

        for(int i=0;i<len;i++){

            char x = s.charAt(i);

            if(i<len-1 && tem.get(x)<tem.get(s.charAt(i+1))){
                res -= tem.get(x);
            }else{
                res += tem.get(x);
            }
            

        }


        return res;

    }
}