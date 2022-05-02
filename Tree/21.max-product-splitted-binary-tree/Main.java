public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    private long max;
    private int MOD = (int)(1e9+7);
    public int maxProduct(TreeNode root)
    {
        max = 0l;
        int sum = getSum(root);
        solve(root,sum);
        return (int)(max%MOD);
    }
    private int getSum(TreeNode root)
    {
        if(root==null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        return left+right+root.val;
    }
    private long solve(TreeNode root,int sum)
    {
        if(root==null) return 0l;
        long left = solve(root.left,sum);
        long right = solve(root.right,sum);
        max = Math.max(max,Math.max(left*(sum-left),right*(sum-right)));
        return left+right+root.val;  
    }
}
