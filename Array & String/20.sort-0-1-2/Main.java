public class Main {
    public static void main(String[] args) {

    }
}


class Solution
{
    public void sortColors(int[] nums)
    {
        int len = nums.length;
        int i = 0,j = 0,k = len-1;
        
        while(j<=k)
        {
            if(nums[j]==0)
            {
                swap(nums,i,j);
                i++;
                j++;
            }
            else if(nums[j]==2)
            {
                swap(nums,j,k);
                k--;
            }
            else
            {
                j++;
            }
        }
    }
    
    private void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}