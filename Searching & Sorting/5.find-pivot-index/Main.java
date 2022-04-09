public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int pivotIndex(int[] nums)
    {
        
        int n = nums.length;
        int[] suffixSum = new int[n];
        int sum = 0;
        for(int i = n-1;i>=0;i--)
        {
            suffixSum[i] = sum;
            sum+=nums[i];
        }
        
        
        sum = 0;
        for(int i = 0;i<n;i++)
        {
            if(sum==suffixSum[i]) return i;
            sum+=nums[i];
        }
        
        return -1;
        
    }
}
