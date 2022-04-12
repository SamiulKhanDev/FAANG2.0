public class Main
{
    public static void main(String[] args) {
        
    }
}
class Solution
{
    
    private class TrieNode
    {
        TrieNode[] children;
        String str ;
        TrieNode()
        {
            this.children = new TrieNode[26];
        }
    }
    
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
            for(int i = 0;i<len;i++)
            {
                char ch = word.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    curr.children[ch-'a'] = new TrieNode();
                    
                }
                curr = curr.children[ch-'a'] ;
            }
            curr.str = word;            
        }
        
        
        public String dfs(TrieNode root)
        {
            
            String curr = "";
            for(TrieNode child:root.children)
            {
                if(child!=null && child.str!=null)
                {
                    String call = dfs(child);
                    if(curr.length()<call.length())
                    {
                        curr = call;
                    }
                }
            }
            if(curr.length()==0) return root.str;
            return curr;
            
            
        }
        
    }
    
    
    
    public String longestWord(String[] words)
    {
        Trie tt = new Trie();
        for(String w:words)
        {
            tt.insert(w);
        }
        String ans = tt.dfs(tt.root);
        if(ans==null) return "";
       return ans;
        
        
        
        
    }
}