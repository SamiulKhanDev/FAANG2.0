public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) 
    {
        int minVal = arr[0];
        int maxVal = arr[0];
    
        int maxProduct = arr[0];
    
        for (int i = 1; i < n; i++)
        {
            if (arr[i] < 0)
            {
                int temp = maxVal;
                maxVal = minVal;
                minVal =temp;
            
            }
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);
            maxProduct = Math.max(maxProduct, maxVal);
        }
        return maxProduct;
    }
}
