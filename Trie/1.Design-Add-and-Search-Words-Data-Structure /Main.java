public class Main {
    public static void main(String[] args) {
        
    }
}
class WordDictionary
{
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

    private TrieNode root;
    public WordDictionary()
    {
        this.root = new TrieNode();
    }
    
    public void addWord(String word)
    {
        TrieNode curr = this.root;
        int len = word.length();
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
        TrieNode curr = this.root;
        return search(word,curr,0,word.length());
    }
    
    
    private boolean search(String word,TrieNode curr,int idx,int len)
    {
        
        if(idx==len-1)
        {
            char ch = word.charAt(idx);
            if(ch!='.')
            {
                if(curr.children[ch-'a']!=null && curr.children[ch-'a'].isEnd) return true;
            }
            else
            {
                for(int i = 0;i<26;i++)
                {
                    if(curr.children[i]!=null && curr.children[i].isEnd)
                    {
                        return true;
                    }
                }
            }
            
            return false;
        }
        
        char ch = word.charAt(idx);
        if(ch!='.')
        {
            if(curr.children[ch-'a']==null) return false;
            boolean flag = search(word,curr.children[ch-'a'],idx+1,len);
            if(flag) return flag;
        }
        else
        {
            for(int i = 0;i<26;i++)
            {
                if(curr.children[i]!=null)
                {
                    if(search(word,curr.children[i],idx+1,len)) return true;
                }
            }
        }
        
        return false;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */