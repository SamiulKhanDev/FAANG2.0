public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    
    private class Pair
    {
        int forward = -1;
        int backward = -1;
        int max = 0;
    }
    public int longestZigZag(TreeNode root)
    {
        Pair p = solve(root);
        return p.max;
    }
    
    public int getMax(int...args)
    {
        int max = Integer.MIN_VALUE;
        for(int arg:args)
        {
            max = Math.max(max,arg);
        }
        return max;
    }
    
    
    public Pair solve(TreeNode root)
    {
        Pair mp = new Pair();
        if(root==null) return mp;
        if(root.left==null && root.right==null)
        {
            mp.forward = 0;
            mp.backward = 0;
            return mp;
        }
        
        Pair lp = solve(root.left);
        Pair rp = solve(root.right);
        
        
        mp.forward = 1 + rp.backward;
        mp.backward = 1 + lp.forward;
        mp.max = getMax(mp.forward,mp.backward,lp.max,rp.max);
        return mp;
        
    }
    
    
}