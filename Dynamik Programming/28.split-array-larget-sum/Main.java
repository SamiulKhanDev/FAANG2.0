public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int splitArray(int[] nums, int m)
    {
        int[] dts = getDetails(nums);//sum,max
        int len = nums.length;
        if(len==m) return dts[1];
        
        return solve(nums,dts[1],dts[0],m);
    }
    
    private int[] getDetails(int[] nums)
    {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num:nums)
        {
            sum+=num;
            max = Math.max(max,num);
        }
        return new int[]{sum,max};
    }
    
    
    public boolean isPossible(int[] nums,int max,int m)
    {
        int nos = 1;
        int sum = 0;
        for(int num:nums)
        {
            if(sum+num<=max)
            {
                sum+=num;
            }
            else
            {
                sum = num;
                nos++;
                if(nos>m) return false;
            }
        }
        
        
        return true;
    }
    
    
    private int solve(int[] nums,int low,int high,int m)
    {
        int max = 0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            if(isPossible(nums,mid,m))
            {
                max = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }   
        return max;
    }
}
