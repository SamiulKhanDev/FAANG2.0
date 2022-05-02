public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution 
{
    private static boolean isPalindrom(String word,int sp,int ep)
    {
        for(int i = sp,j=ep;i<=j;i++,j--)
        {
            if(word.charAt(i)!=word.charAt(j)) return false;
        }
        
        return true;
    }
    
    
    private class TrieNode
    {
        TrieNode[] children;
        int index;
        List<Integer> palindroms;
        TrieNode()
        {
            this.children = new TrieNode[26];
            this.index = -1;
            this.palindroms = new ArrayList<>();
        }
    }
    
    
    private class Trie
    {
        TrieNode root;
        Trie()
        {
            this.root = new TrieNode();
        }
        
        
        public void insert(String word,int i)
        {
            TrieNode curr = this.root;
            int len = word.length();
            for(int j = len-1;j>=0;j--)
            {
                int idx = word.charAt(j)-'a';
                if(curr.children[idx]==null)
                {
                    curr.children[idx] = new TrieNode();
                }
                if(isPalindrom(word,0,j))
                {
                    curr.palindroms.add(i);
                }
                curr = curr.children[idx];
            }
            
            curr.index = i;
            curr.palindroms.add(i);
        }
        
        public void search(String word,int i,List<List<Integer>> list)
        {
            TrieNode curr = this.root;
            int len = word.length();
            for(int j =0;j<len;j++)
            {
                int idx = word.charAt(j)-'a';
                if(curr.index>=0 && curr.index!=i && isPalindrom(word,j,len-1))
                {
                    list.add(new ArrayList<>(Arrays.asList(i,curr.index)));
                }
                
                if(curr.children[idx]==null) return;
                curr = curr.children[idx];
            }
            
            for(int idx:curr.palindroms)
            {
                if(i!=idx)
                {
                    list.add(new ArrayList<>(Arrays.asList(i,idx)));
                }
            }
            
        }
        
        
        
        
    }
    
    
    
    
    public List<List<Integer>> palindromePairs(String[] words) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        Trie tt = new Trie();
        for(int i = 0;i<n;i++)
        {
            String word = words[i];
            tt.insert(word,i);
        }
        
        for(int i = 0;i<n;i++)
        {
            String word = words[i];
            tt.search(word,i,ans);
        }
        return ans;
        
    }
}