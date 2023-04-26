class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        int rig = 0;
        int lef = 0;
        int res = 0;

        
        while(rig<s.length()){

            char input = s.charAt(rig);

            map.put(input,map.getOrDefault(input,0)+1);


                while(map.size()>2){

                    char del = s.charAt(lef);
                    int count = map.get(del);

                    if(count==1){
                            map.remove(del);
                    }else{
                        map.put(del,map.get(del)-1);
                    }

                    lef++;
                }

            res = Math.max(res,rig-lef+1);
            rig++;
        }        
        return res;

    }
}