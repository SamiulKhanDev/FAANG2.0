public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int[] constructArray(int n, int k)
    {
        
        boolean isEven = false;
        if(k%2==0)
        {
            isEven = true;
        }
        
        int index = 0;
        int high = n;
        int low = 1;
        int[] arr = new int[n];
        arr[index++] = low++;
        while(k>1)
        {
            arr[index++] = high--;
            k--;
            if(k>1)
            {
                arr[index++] = low++;
                k--;
            }
        }
        
        if(isEven)
        {
            for(int i=high;i>=low && index<n ;i--)
            {
                arr[index++] = i;
            }
        }
        else
        {
            for(int i=low;i<=high && index<n;i++)
            {
                arr[index++] = i;
            }
        }
        
        return arr;
    }
}
