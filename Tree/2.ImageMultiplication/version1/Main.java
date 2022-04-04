public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution {
    private static long inf = (long)(1e9+7);
    public long imgMultiply(Node root)
    {
        long ans = solve(root,root);
        
        return ans%inf;
        
    }
    
    private final long solve(Node r1,Node r2)
    {
        
        if(r1==null||r2==null) return 0l;
        
        
        
        long sum = r1.data*r2.data;
        long left = solve(r1.left,r2.right);
        if(r1!=r2)
        {
            left+=  solve(r1.right,r2.left);
        }
       
        
        return sum+left;
        
        
    }
}