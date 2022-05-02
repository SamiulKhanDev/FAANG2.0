public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public class Pair
    {
        int max=0;
        int ht = -1;
    }
    
    
    public int diameterOfBinaryTree(TreeNode root)
    {
        
        return solve(root).max;
        
    }
    
    public Pair solve(TreeNode root)
    {
        
        Pair mp = new Pair();
        if(root==null)
        {
            return mp;
        }
        Pair lp = solve(root.left);
        Pair rp = solve(root.right);
        
        int md = lp.ht+rp.ht+2;
        mp.max = Math.max(md,Math.max(lp.max,rp.max));
        mp.ht = Math.max(lp.ht,rp.ht)+1;
        
        return mp;
        
        
        
        
        
        
    }
}
