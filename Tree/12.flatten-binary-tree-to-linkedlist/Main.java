public class Main
{
    public static void main(String[] args) {
        
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public void flatten(TreeNode root) 
    {
        solve(root);
    }
    
    
    public void solve(TreeNode root)
    {
        if(root==null) return;
        
        
        solve(root.left);
        
        TreeNode rp = root.right;
        TreeNode lp = root.left;
        root.right = null;
        root.left = null;
        root.right = lp;
        TreeNode rmn = rmn(root);
        if(rmn!=null) rmn.right = rp;
        
        solve(root.right);
        
        
        
        
    }
    
    
    public TreeNode rmn(TreeNode node)
    {
        if(node==null) return node;
        if(node.left==null && node.right==null) return node;
        TreeNode n = rmn(node.right);
        
        return n;
        
    }
}