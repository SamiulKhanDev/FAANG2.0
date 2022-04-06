public class Main {
    public static void main(String[] args) {

    }
}
class Compute {
    
    public static int maxSumBS(int arr[], int n)
    {
        int[] lis = new int[n];
        
        for(int i = 0;i<n;i++)
        {
            int max = 0;
            for(int j = i-1;j>=0;j--)
            {
                if(arr[i]>arr[j])
                {
                    max = Math.max(max,lis[j]);
                }
            }
            
            lis[i] = max+arr[i];
        }
        int[] lds = new int[n];
        
        for(int i = n-1;i>=0;i--)
        {
            int max = 0;
            for(int j = i+1;j<n;j++)
            {
                if(arr[i]>arr[j])
                {
                    max = Math.max(max,lds[j]);
                }
            }
            
            lds[i] = max+arr[i];
        }
        
        int max = 0;
        for(int i = 0;i<n;i++)
        {
            max = Math.max(max,lis[i]+lds[i]-arr[i]);
        }
        
        return max;
    }
}
