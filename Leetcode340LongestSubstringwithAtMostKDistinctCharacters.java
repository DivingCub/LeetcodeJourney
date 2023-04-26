class Solution {
   public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int lef  = 0;
    int rig = 0;
    int resLen = 0;

    for(;rig<s.length();rig++){

        char input = s.charAt(rig);
        map.put(input,map.getOrDefault(input,0)+1);

        while(map.size()>k){
            char out = s.charAt(lef);
            if(map.containsKey(out)){
                  map.put(out,map.get(out)-1);
                  if(map.get(out) == 0){
                      map.remove(out);
                  }
            }
            lef++;
        }
        resLen = Math.max(resLen,rig-lef+1);
    }
    return resLen;
}
}