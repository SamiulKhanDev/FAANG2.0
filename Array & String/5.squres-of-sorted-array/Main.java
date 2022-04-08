public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    public int[] sortedSquares(int[] nums) 
    {
        int len = nums.length;
        int[] ans = new int[len];
        int i = 0;
        int j = len-1;
        
        int idx = len-1;
        while(idx>=0)
        {
            int ith = nums[i]*nums[i];
            int jth = nums[j]*nums[j];
            
            if(ith==jth)
            {
                ans[idx--] = ith;
                if(idx<0) break;
                ans[idx--] = jth;
                i++;
                j--;
            }
            else if(ith<jth)
            {
                ans[idx--] = jth;
                j--;
            }
            else
            {
                ans[idx--] = ith;
                i++;
            }
        }
        
        return ans;
        
    }
}
