public class Main {
    public static void main(String[] args) {

    }
}

class MapSum
{
    
    private class TrieNode
    {
        TrieNode[] children;
        int sum;
        TrieNode()
        {
            this.children = new TrieNode[26];
            this.sum = 0;
        }
    }
    
    
    private TrieNode root;
    private HashMap<String,Integer> map;

    public MapSum() 
    {
        
        this.root = new TrieNode();
        this.map = new HashMap<>();
        
    }
    
    public void insert(String key, int val)
    {
        
        if(map.containsKey(key)==false)
        {
            map.put(key,val);
            insertInTrie(key,val);
        }
        else
        {
            int oval = map.get(key);
            map.put(key,val);
            updateTheValues(key,oval,val);
        }
        
    }
    
    private void insertInTrie(String word,int key)
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
            curr.children[ch-'a'].sum+=key;
            curr = curr.children[ch-'a'];
        }
    }
    
    private void updateTheValues(String word,int oval,int nval)
    {
        TrieNode curr = this.root;
        int len = word.length();
        for(int i = 0;i<len;i++)
        {
            char ch = word.charAt(i);
            curr.children[ch-'a'].sum-=oval;
            curr.children[ch-'a'].sum+=nval;
            curr = curr.children[ch-'a'];
        }
    }
    
    
    
    public int sum(String prefix)
    {
        TrieNode curr = this.root;
        int s = 0;
        int len = prefix.length();
        for(int i = 0;i<len;i++)
        {
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a']==null) return 0;
            curr = curr.children[ch-'a'];
            
        }
        s+=curr.sum;
        return s;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
