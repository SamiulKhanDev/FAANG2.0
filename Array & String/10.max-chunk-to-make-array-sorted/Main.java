public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution 
{
    public int maxChunksToSorted(int[] arr)
    {
        int len = arr.length;
        int[] suffixMin = new int[len+1];
        int min = Integer.MAX_VALUE;
        suffixMin[len] = min;
        for(int i = len-1;i>=0;i--)
        {
            min = Math.min(min,arr[i]);
            suffixMin[i] = min;
        }
        
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++)
        {
            max = Math.max(max,arr[i]);
            if(max < suffixMin[i+1]) count++;
        }
        
        return count;
        
    }
}