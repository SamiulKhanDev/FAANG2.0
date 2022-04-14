public class Main
{
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
        
        public void insert(String nword)
        {
            String word = new StringBuilder(nword).reverse().toString();
            int len = word.length();
            TrieNode curr = root;
            for(int i = 0;i<len;i++)
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
            // System.out.println(word);
            int len = word.length();
            TrieNode curr = root;
            for(int i = 0;i<len;i++)
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
        if(tt.root.children[letter-'a']==null) return false;
        
        
        return tt.search(new StringBuilder(sb.toString()).reverse().toString());
        
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

 //will pass all the cases, results a tle