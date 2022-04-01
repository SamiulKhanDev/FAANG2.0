public class Main {
    public static void main(String[] args) {
        
    }
}


class Solution
{
    public int minSubArrayLen(int target, int[] nums)
    {
        
        int si = 0,ei = 0,len = nums.length,minLength = Integer.MAX_VALUE;
        long sum = 0l;
        while(ei<len)
        {
            sum+=nums[ei]*1l;
            ei++;
            while(sum>=target && si<len)
            {
                minLength = Math.min(minLength,ei-si);
                sum-=nums[si++];
                
            }
           
        }
        if(minLength==Integer.MAX_VALUE) return 0;
        
        return minLength;
        
    }
}