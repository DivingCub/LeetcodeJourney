class Solution {
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        char[] Sc = s.toCharArray();
        char[] Tc = t.toCharArray();

        HashMap<Character,Integer> Covered = new HashMap<>();
        HashMap<Character,Integer> Check = new HashMap<>();
    
        int start = 0;
        int lef = 0;
        int rig = 0;
        int validN = 0;
        int resLen = Integer.MAX_VALUE;

        for(char Tx : Tc){
            Check.put(Tx,Check.getOrDefault(Tx,0)+1);
        }

        while(rig<s.length()){
            char input = s.charAt(rig);
            rig++;
            Covered.put(input,Covered.getOrDefault(input,0)+1);  
            //这里有个坑，如何只加一次
            if(Covered.get(input).equals(Check.get(input))){
                    validN++;
            }


            while(validN == Check.size()){
                if(rig - lef < resLen){
                    resLen = rig - lef;
                    start = lef;
                }
                char out = s.charAt(lef);
                lef++;
                if(Check.containsKey(out)){
                     Covered.put(out,Covered.get(out)-1);
                    if(Covered.get(out)< Check.get(out)){
                        validN--;
                    }
                }      
            }
        }

        return resLen == Integer.MAX_VALUE? "" : s.substring(start,start+resLen);
        //再次学习一下subString
    }
}