class Solution {

    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public List<String> findWords(char[][] board, String[] words) {

        Set<String> resultSet = new HashSet<>();

        TrieNode root =  buildTrie(words);

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        StringBuffer sb = new StringBuffer();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                helper(resultSet,sb,board,i,j,root,visited);
            }
        }  

        return new ArrayList<>(resultSet);
    }

    private void helper(Set<String> resultSet,StringBuffer sb,char[][]board,int i,int j,TrieNode node,boolean[][]visited){

     if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]|| node.children[board[i][j]-'a']==null){
         return;
     }   

    sb.append(board[i][j]);

    if(node.children[board[i][j]-'a'].isEnd){
        resultSet.add(sb.toString());
    }

    visited[i][j] = true;

    for(int[] dir: dirs){
        helper(resultSet,sb,board,i+dir[0],j+dir[1],node.children[board[i][j]-'a'],visited);
    }

    visited[i][j] = false;
    sb.deleteCharAt(sb.length()-1);

    }

    private TrieNode buildTrie(String[] words){

        TrieNode root = new TrieNode();
        for(String curWord : words){

            char[] arr = curWord.toCharArray();
            TrieNode cur = root;
            for(char input: arr){
                if(cur.children[input -'a'] ==null){
                    cur.children[input -'a'] = new TrieNode();
                }
               cur = cur.children[input -'a'];
            }
            cur.isEnd = true;
        }
        return root;
    }

}

class TrieNode{

    boolean isEnd = false;
    Trie[26];

}