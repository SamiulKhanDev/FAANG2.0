public class Main {
    public static void main(String[] args) {
        
    }
}
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        return solve(arr,n);
    }
    
    public static long solve(int[] arr,int n)
    {
        
       long[][] dp = new long[n][n];
       
       for(int g = 0;g<n;g++)
       {
           for(int i = 0,j = g;j<n;j++,i++)
           {
               if(g==0)
               {
                   dp[i][j] = arr[i];
               }
               else if(g==1)
               {
                   dp[i][j] = Math.max(arr[i],arr[j]);
               }
               else
               {
                   long f1 = dp[i+2][j];
                   long f2 = dp[i+1][j-1];
                   long f3 = dp[i][j-2];
                   
                   dp[i][j] = Math.max((long)arr[i]+Math.min(f1,f2),(long)arr[j]+Math.min(f2,f3));
                   
               }
               
           }
       }
       
       return dp[0][n-1];
        
    }
    
    
}
