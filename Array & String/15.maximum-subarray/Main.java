public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int maxSubArray(int[] nums)
    {
        
        int max = nums[0];
        int n = nums.length;
        int sum = nums[0];
        for(int i = 1;i<n;i++)
        {
            if(sum>=0)
            {
                sum+=nums[i];
            }
            else
            {
                sum = nums[i];
            }
            
            max = Math.max(max,sum);
            
        }
        
        return max;
        
    }
}
