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
    
    private class Pair
    {
        TreeNode node;
        int index;
        Pair(TreeNode node,int index)
        {
            this.node = node;
            this.index = index;
            
        }
        
    }
    public int widthOfBinaryTree(TreeNode root)
    {
        if(root==null) return 0;
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        
        while(queue.isEmpty()==false)
        {
            int lmn = queue.peek().index;
            int rmn = queue.peek().index;
            int size = queue.size();
            while(size-->0)
            {
                Pair rem = queue.poll();
                
                rmn = rem.index;
                if(rem.node.left!=null)
                {
                    queue.add(new Pair(rem.node.left,2*rmn+1));
                }
                if(rem.node.right!=null)
                {
                    queue.add(new Pair(rem.node.right,2*rmn+2));
                }
                
            }
            
            max = Math.max(max,rmn-lmn+1);
            
            
        }
        
        return max;
        
        
    }
}
//https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/