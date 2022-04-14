public class Main {
    public static void main(String[] args) {

    }
}

class StreamChecker
 {
    Trie tt;
    private class TrieNode
    {
        TrieNode[] children;
        boolean isEnd;
        TrieNode()
        {
            this.children = new TrieNode[26];
             this.isEnd = false;
        }
    }
    
    
    private StringBuilder sb;
    private class Trie
    {
        TrieNode root;
        
        Trie()
        {
            this.root = new TrieNode();
           
            
        }
        
        public void insert(String word)
        {
            
            int len = word.length();
            TrieNode curr = root;
            for(int i = len-1;i>=0;i--)
            {
                char ch = word.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    curr.children[ch-'a'] = new TrieNode();
                }
                
                curr = curr.children[ch-'a'];
            }
            curr.isEnd = true;
        }
        
        public boolean search(String word)
        {
            int len = word.length();
            TrieNode curr = root;
            for(int i = len-1;i>=0;i--)
            {
                char ch = word.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    break;
                }
                else
                {
                    if(curr.children[ch-'a'].isEnd) return true;
                    curr = curr.children[ch-'a'];
                }
                
            }
            return curr.isEnd;
        }
        
    }

    public StreamChecker(String[] words)
    {
        
        this.tt = new Trie();
        this.sb = new StringBuilder();
        for(String w:words)
        {
            tt.insert(w);
        }
        
    }
    
    public boolean query(char letter)
    {
        sb.append(letter);
        return tt.search(sb.toString());
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
