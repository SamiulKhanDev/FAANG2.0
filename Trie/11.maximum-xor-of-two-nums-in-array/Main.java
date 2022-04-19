public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    
    private class Trie
    {
        private class TrieNode
        {
            int num;
            TrieNode one;
            TrieNode zero;
        }
        
        private TrieNode root;
        Trie()
        {
            this.root = new TrieNode();
        }
        
        
        public void insert(int num)
        {
            TrieNode curr = root;
            for(int i = 30;i>=0;i--)
            {
                int mask = (1<<i);
                int bit = (num&mask);
                if(bit==0)
                {
                    if(curr.zero==null)
                    {
                        curr.zero = new TrieNode();
                        
                    }
                    curr = curr.zero;
                    
                }
                else
                {
                    if(curr.one==null)
                    {
                        curr.one = new TrieNode();
                        
                    }
                    curr = curr.one;
                }
            }
            
            
            curr.num = num;
        }
        public int search(int num)
        {
            TrieNode curr = root;
            for(int i = 30;i>=0;i--)
            {
                int mask = (1<<i);
                int bit = (num&mask);
                if(bit==0)
                {
                    if(curr.zero!=null)
                    {
                        curr = curr.zero;
                    }
                    else
                    {
                        curr = curr.one;
                    }
                    
                }
                else
                {
                    if(curr.one!=null)
                    {
                        curr = curr.one;
                    }
                    else
                    {
                        curr = curr.zero;
                    }
                }
            }
            
            
            return curr.num;
        }
        
    }
    
    public int findMaximumXOR(int[] nums)
    {
        Trie tt = new Trie();
        for(int num:nums)
        {
            tt.insert(num);
        }
        
        int max = 0;
        for(int num:nums)
        {
            int com = ~num;
            int val = tt.search(com);
            // System.out.println(num+" -> "+val);
            max = Math.max(max,num^val);
        }
        
        return max;
        
        
        
    }
}
