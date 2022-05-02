public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        
        if(root==null) return false;
        if(root.left==null && root.right==null)
        {
            if(root.val==targetSum) return true;
            return false;
        }
        
        boolean left = hasPathSum(root.left,targetSum-root.val);
        if(left) return true;
        boolean right = hasPathSum(root.right,targetSum-root.val);
        if(right) return true;
        
        return false;
        
    }
}