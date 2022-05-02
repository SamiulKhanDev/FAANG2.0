public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int sumNumbers(TreeNode root)
    {
        List<String> list = solve(root);
        int sum = 0;
        for(String num:list)
        {
            sum+= Integer.parseInt(num);
        }
        
        return sum;
        
    }
    
    private List<String> solve(TreeNode root)
    {
        List<String> ml = new ArrayList<>();
        
        if(root==null) return ml;
        if(root.left==null && root.right==null)
        {
            ml.add(root.val+"");
            return ml;
        }
        
        List<String> ll = solve(root.left);
        List<String> rl = solve(root.right);
        
        for(String s:ll)
        {
            ml.add(root.val+s);
        }
        for(String s:rl)
        {
            ml.add(root.val+s);
        }
        
        return ml;
        
    }
    
    
}
