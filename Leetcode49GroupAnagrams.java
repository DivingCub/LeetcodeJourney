class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        int len = strs.length;

        for(int i=0;i<len;i++){

            String str = strs[i];

            char[] chartem = str.toCharArray();

            Arrays.sort(chartem);
            //这种生成String的方法非常特别，特别不一样
            String key = new String(chartem);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        
        return new ArrayList< List<String> >(map.values());
        
    }
}

//上面是利用排序来完成，那么如果用其他方式以来完成呢？

//下面利用字母数字来进行逐一的统计：

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        int len = strs.length;

        for(int i=0;i<len;i++){


            int[] counts = new int[26];

            String str = strs[i];

            int lenth = str.length();

            for(int j=0;j<lenth;j++){
                counts[str.charAt(j)-'a']++;
            }

            StringBuffer sb = new StringBuffer();
    
            for(int k=0;k<26;k++){
                
                if(counts[k]!=0){
                    sb.append((char)('a'+k));
                    sb.append(counts[k]);
                }
            }

            String key = sb.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList< List<String> >(map.values());
        
    }
}



//  char[] chartem = str.toCharArray();

//             Arrays.sort(chartem);
//             //这种生成String的方法非常特别，特别不一样
//             String key = new String(chartem);
//             List<String> list = map.getOrDefault(key,new ArrayList<String>());
//             list.add(str);
//             map.put(key,list);