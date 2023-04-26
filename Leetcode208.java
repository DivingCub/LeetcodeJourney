class Trie {

    class TrieNode{

        private boolean isEnd;
        TrieNode[] next;

        public TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();   
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char x: word.toCharArray()){
            if(node.next[x-'a']==null){
                node.next[x-'a'] = new TrieNode();
            }
            node = node.next[x-'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char x: word.toCharArray()){
            node = node.next[x-'a'];
            if(node ==null){
                return false;
            }
        }
        return node.isEnd;     
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char x:prefix.toCharArray()){
            node = node.next[x-'a'];
            if(node ==null){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */