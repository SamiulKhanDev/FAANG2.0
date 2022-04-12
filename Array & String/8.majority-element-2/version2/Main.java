public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public List<Integer> majorityElement(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        int num1 = nums[0],count1 = 1;
        int num2 = nums[0],count2 = 0;
        
        for(int i = 1;i<len;i++)
        {
            if(nums[i]==num1)
            {
                count1++;
            }
            else if(nums[i]==num2)
            {
                count2++;
            }
            else
            {
                if(count1==0)
                {
                    num1 = nums[i];
                    count1 = 1;
                }
                else if(count2==0)
                {
                    num2 = nums[i];
                    count2 = 1;
                }
                else
                {
                    count1--;
                    count2--;
                }
            }
        }
        
        int freq1 = 0,freq2 = 0;
        for(int num:nums)
        {
            if(num==num1)
            {
                freq1++;
            }
            else if(num==num2)
            {
                freq2++;
            }
        }
        if(freq1 > len/3) ans.add(num1);
        if(freq2 > len/3) ans.add(num2);
        
        return ans;
        
        
        
    }
}
