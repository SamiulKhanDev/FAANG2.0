public class Main {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int pathSum(TreeNode root, int targetSum)
    {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        return solve(root,0,targetSum,map);
        
    }
    
    private final int solve(TreeNode root,int csum,int target,HashMap<Integer,Integer> prefixMap)
    {

        if(root==null) return 0;
        
        
        int res = 0;
        csum+=root.val;
        
        res+= prefixMap.getOrDefault(csum-target,0);
        prefixMap.put(csum,prefixMap.getOrDefault(csum,0)+1);
        
        int left = solve(root.left,csum,target,prefixMap);
        int right = solve(root.right,csum,target,prefixMap);
        
        res+=left+right;
        prefixMap.put(csum,prefixMap.getOrDefault(csum,0)-1);
        return res;
        
        
    }
    
}
