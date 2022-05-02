public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    private class Pair
    {
        int max = Integer.MIN_VALUE;
        int rtr = 0;
    }
    int maxPathSum(Node root)
    { 
        return solve(root,null).max;
    } 
    
    private Pair solve(Node root,Node par)
    {
        Pair mp = new Pair();
        if(root==null) return mp;
        
        
        Pair lp = solve(root.left,root);
        Pair rp = solve(root.right,root);
        
        
        if(root.left!=null && root.right!=null)
        {
            mp.max = Math.max(mp.max,lp.rtr+root.data+rp.rtr);
        }
        else if(root.left!=null && par==null)
        {
            mp.max = Math.max(mp.max,lp.rtr+root.data);
        }
        else if(root.right!=null && par==null)
        {
            mp.max = Math.max(mp.max,rp.rtr+root.data);
        }
        mp.max = Math.max(mp.max,Math.max(rp.max,lp.max));
        if(root.left!=null && root.right!=null)
        {
            mp.rtr = root.data + Math.max(lp.rtr,rp.rtr);
        }
        else if(root.left!=null)
        {
            mp.rtr = root.data + lp.rtr;
        }
        else if(root.right!=null)
        {
            mp.rtr = root.data + rp.rtr;
        }
        else
        {
            mp.rtr = root.data;
        }
        return mp;
        
        
    }
    
    
    
}
