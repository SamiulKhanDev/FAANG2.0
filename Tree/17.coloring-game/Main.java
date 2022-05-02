public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public boolean btreeGameWinningMove(TreeNode root, int n, int x)
    {
        TreeNode xColoured = findNode(root,x);
        
        int leftSize = getSize(xColoured.left);
        int rightSize = getSize(xColoured.right);
        int pSize = n-leftSize-rightSize-1;
        
        
        if(pSize==0)
        {
            if(leftSize==rightSize) return false;
            else if(leftSize>rightSize+1) return true;
            else if(leftSize+1>rightSize) return true;
            return false;
        }
        else
        {
            if((pSize > rightSize+1+leftSize ) || (rightSize > pSize+1+leftSize )|| (leftSize > pSize+1+rightSize ))
            {
                return true;
            }
            
        }
        
        return false;
    }
    
    private TreeNode findNode(TreeNode root,int x)
    {
        if(root==null) return null;
        
        if(root.val==x) return root;
        TreeNode left = findNode(root.left,x);
        if(left!=null) return left;
        TreeNode right = findNode(root.right,x);
        if(right!=null) return right;
        return null;
    }
    
    private int getSize(TreeNode node)
    {
        if(node==null) return 0;
        int left = getSize(node.left);
        int right = getSize(node.right);
        
        return left+right+1;
    }
    
}
