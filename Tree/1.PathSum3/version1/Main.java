public class Main {
    public static void main(String[] args) {

    }
    
    /**
     * 
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
}
class Solution {
    private static int count;
    public int pathSum(TreeNode root, int targetSum) 
    {
        count = 0;
        
        solve(root,targetSum);
        
        return count;
    
    }
    
    
    
    public HashMap<Integer,Integer> solve(TreeNode root,int target){
        if(root==null) return new HashMap<>();  
        if(root.left==null && root.right==null){
            HashMap<Integer,Integer> map = new HashMap<>();
            if(root.val==target){
                       count++;
                                }
             map.put(root.val,1);
            return map;
        } 
        HashMap<Integer,Integer> lm = solve(root.left,target);
        HashMap<Integer,Integer> rm = solve(root.right,target);
        HashMap<Integer,Integer> llm = new HashMap<>();
        HashMap<Integer,Integer> rrm = new HashMap<>();
        if(root.val==target) count++;
        if(lm.size()>0){
            for(int key:lm.keySet()){
                if(root.val+key==target) count+=lm.get(key);
                llm.put(root.val+key,llm.getOrDefault(root.val+key,0)+lm.get(key));
            }
        }
        if(rm.size()>0){
           for(int key:rm.keySet()){
                if(root.val+key==target) count+=rm.get(key);
                rrm.put(root.val+key,rrm.getOrDefault(root.val+key,0)+rm.get(key));
            } 
        }
         HashMap<Integer,Integer> map = new HashMap<>();
        if(llm.size()>0){
            for(int key:llm.keySet()){
                map.put(key,map.getOrDefault(key,0)+llm.get(key));
            }
        }
        if(rrm.size()>0){
            for(int key:rrm.keySet()){
                map.put(key,map.getOrDefault(key,0)+rrm.get(key));
            }
        }
        
        map.put(root.val,map.getOrDefault(root.val,0)+1);
       
        
        return map;
        
    }
    
}

//this is not optimized,please refer to the version2 of this solution,where i have used a prefix map;