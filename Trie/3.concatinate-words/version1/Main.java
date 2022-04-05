public class Main {
    public static void main(String[] args) {

    }
}
class Solution
{
    
    
    public class TrieNode
    {
        TrieNode[] children;
        boolean isEnd;
        TrieNode()
        {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    
    
    public class Trie
    {
        TrieNode root;
        Trie()
        {
            this.root = new TrieNode();
        }
        
        public void insert(String str)
        {
            int len = str.length();
            TrieNode curr = this.root;
            for(int i = 0;i<len;i++)
            {
                char ch = str.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isEnd = true;
        }
        
        public boolean search(String str)
        {
            int len = str.length();
            TrieNode curr = this.root;
            for(int i = 0;i<len;i++)
            {
                char ch = str.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    return false;
                }
                curr = curr.children[ch-'a'];
            }
            
            return curr.isEnd;
        }
        
    }
    
    public int dfs(String str,Trie tt)
    {
        int len = str.length();
        if(len==0) return 0;
        int count = 0;
        for(int i = 0;i<len;i++)
        {
            String prefix = str.substring(0,i+1);
            if(tt.search(prefix))
            {
                String suffix = str.substring(i+1);
                int val = dfs(suffix,tt);
                int rest = 1 + val;
                if(val!=-1)
                {
                    count = Math.max(count,rest);
                }
                
            }
        }
        
        return count==0?-1:count;
    }
    
    
    
    
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        
        Trie tt = new Trie();
        for(String str:words)
        {
            tt.insert(str);
        }
        
        List<String> ans = new ArrayList<>();
        
        for(String str:words)
        {
            if(dfs(str,tt)>=2)
            {
                ans.add(str);
            }
        }
        
        return ans;
       
    }
}
