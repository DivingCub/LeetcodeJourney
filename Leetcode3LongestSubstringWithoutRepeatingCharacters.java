class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        
        int lef = 0;
        int rig = 0;
        int res = 0;
        
        for(;rig<s.length();rig++){

            char input = s.charAt(rig);

            while(set.contains(input)){
                set.remove(s.charAt(lef));
                lef++;
            }

            set.add(input);
            res = Math.max(res,rig - lef+1);
        }      
        
        return res;
    }
}