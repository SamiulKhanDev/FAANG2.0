public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution 
{
    public int majorityElement(int[] nums) 
    {
        
        int len = nums.length;
        int count = 1;
        int num = nums[0];
        for(int i = 1;i<len;i++)
        {
            if(nums[i]==num)
            {
                count++;
            }
            else
            {
                if(count==1)
                {
                    num = nums[i];
                }
                else
                {
                    count--;
                }
            }
        }
        
        return num;
        
    }
}