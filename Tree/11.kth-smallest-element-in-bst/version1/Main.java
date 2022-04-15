public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    private PriorityQueue<Integer> minheap;
    public int KthSmallestElement(Node root, int k)
    {
        minheap = new PriorityQueue<>(Collections.reverseOrder());
        solve(root,k);
        if(minheap.size()!=k) return -1;
        return minheap.peek();
    }
    
    private void solve(Node root,int k)
    {
        if(root==null) return;
        solve(root.left,k);
        if(minheap.size()<k)
        {
            minheap.add(root.data);
        }
        else
        {
            if(minheap.peek()>root.data)
            {
                minheap.poll();
                minheap.add(root.data);
            }
            
        }
        
        solve(root.right,k);
        
        
        
    }
    
    
    
}

