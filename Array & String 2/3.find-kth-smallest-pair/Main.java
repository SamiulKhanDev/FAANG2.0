public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution 
{
    public int smallestDistancePair(int[] nums, int k) 
    {
        Arrays.sort(nums);
        int len = nums.length;
        int lo = 0,hi = nums[len-1]-nums[0];
        
        while(lo<hi)
        {
            int mid = (lo+hi)/2;
            
            
            if(isPossible(nums,mid,k))
            {
                hi = mid;
            }
            else
            {
                lo = mid+1;
            }
        }
        
        
        return lo;
        
    }
    
    private final boolean isPossible(int[] nums,int mid,int k)
    {
        int count = 0;
        int left = 0;
        for(int right = 1;right<nums.length;right++)
        {
            while(nums[right]-nums[left]>mid)
            {
                left++;
            }
            
            count+= right-left;
            if(count>=k) return true;
        }
        
        
        return false;
        
        
    }
    
    
    
}