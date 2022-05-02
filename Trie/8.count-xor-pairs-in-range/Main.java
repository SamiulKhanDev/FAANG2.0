public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    private static int maxbit = 14;// 14 bit is required to represent 2*10^4
    private class TrieNode
    {
        int count;
        TrieNode left;
        TrieNode right;
        TrieNode(){}
        TrieNode(int count)
        {
            this.count = count;
        }
    }
    
    private class Trie
    {
        TrieNode root;
        Trie()
        {
            this.root = new TrieNode();
        }
        
        public void insert(int val)
        {
            TrieNode curr = root;
            for(int i = maxbit;i>=0;i--)
            {
                int mask = (1<<i);
                int bit = ((mask&val)==0?0:1);
                if(bit==0)
                {
                    if(curr.left==null)
                    {
                        curr.left = new TrieNode(1);
                    }
                    else
                    {
                        curr.left.count++;
                    }
                    curr = curr.left;
                }
                else
                {
                    if(curr.right==null)
                    {
                        curr.right = new TrieNode(1);
                    }
                    else
                    {
                        curr.right.count++;
                    }
                    curr = curr.right;
                }
            }
            
        }
        
        
    }
    public int query(TrieNode node,int range,int val,int index)
    {
        if(node==null) return 0;
        if(index==-1) 
        {
            if(node==null) return 0;
            return node.count;
        }
        int bitV = ((val&(1<<index))==0?0:1);
        int bitR = ((range&(1<<index))==0?0:1);

        if(bitV==0)
        {
            if(bitR==0)
            {
                return query(node.left,range,val,index-1);
            }
            else
            {
                return (node.left!=null?node.left.count:0) + query(node.right,range,val,index-1); 
            }
        }
        else
        {
            if(bitR==0)
            {
                return  query(node.right,range,val,index-1);
            }
            else
            {
                return query(node.left,range,val,index-1) + (node.right!=null?node.right.count:0); 
            }
        }



    }

        
        
    
    
    public int countPairs(int[] nums, int low, int high)
    {
        Trie tt = new Trie();
        int count = 0;
        for(int num:nums)
        {
            int hc= query(tt.root,high,num,maxbit);
            int lc =query(tt.root,low-1,num,maxbit);
            // System.out.println(hc+" "+lc);
            tt.insert(num);
            count+=hc-lc;
        }
        
        return count;
    }
}

