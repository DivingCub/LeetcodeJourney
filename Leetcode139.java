class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {


        int size = wordDict.size();
        Set<String> set = new HashSet<>();

        for( int i=0; i<size;i++){
            set.add(wordDict.get(i));
        }

        int len = s.length();

        boolean[] isWord = new boolean[len+1];

        isWord[0] = true;

        for(int i=1;i<=len;i++){

            for(int j=0;j<i;j++){

            if(set.contains(s.substring(j,i)) && isWord[j])
                isWord[i] = true;
            }
        }

        return isWord[len];
    }

}