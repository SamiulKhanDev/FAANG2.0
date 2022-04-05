public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4)
    {
        int len = nums1.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++)
        {
            for(int j = 0;j<len;j++)
            {
                int sum = nums1[i] + nums2[j];
                int prev = map.getOrDefault(sum,0);
                map.put(sum,prev+1);
            }
        }
        
        int count = 0;
        for(int i = 0;i<len;i++)
        {
            for(int j = 0;j<len;j++)
            {
                int sum = nums3[i] + nums4[j];
                count += map.getOrDefault(-sum,0);
            }
        }
        
        
        
        
        return count;
        
        
    }
}