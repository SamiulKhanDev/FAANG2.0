public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    private int sum = 0;
    public int sumNumbers(TreeNode root)
    {
        solve(root,0);
        return sum;
        
    }
    
    private void solve(TreeNode root,int num)
    {
        
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            sum+= (num*10+root.val);
            return;
        }
        
        
        solve(root.left,num*10+root.val);
        solve(root.right,num*10+root.val);
        
        
        
    }
    
    
}
