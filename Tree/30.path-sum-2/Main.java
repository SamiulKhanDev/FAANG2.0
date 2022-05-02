public class Main {
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
   
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> ml = new LinkedList<>();
        
        if(root==null) return ml;
        if(root.left==null && root.right==null)
        {
            if(root.val==targetSum)
            {
                List<Integer> bl = new LinkedList<>();
                bl.add(root.val);
                ml.add(bl);
            }
            return ml;
        }
        
        List<List<Integer>> left = pathSum(root.left,targetSum-root.val);
        List<List<Integer>> right = pathSum(root.right,targetSum-root.val);
        // System.out.println(left);
        // System.out.println(right);
        if(left.size()!=0)
        {
            for(List<Integer>ll:left)
            {
                ll.add(0,root.val);
                ml.add(ll);
            }
        }
        if(right.size()!=0)
        {
            for(List<Integer>rr:right)
            {
                rr.add(0,root.val);
                ml.add(rr);
            }
        }
        
        return ml;
    }
    
    
    
    
}