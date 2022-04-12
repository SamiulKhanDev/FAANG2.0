public class Main {
    public static void main(String[] args) {

    }
}

class Solution{
    public int cutRod(int price[], int n)
    {
        int[] dp = new int[n+1];
        
        
        dp[0] = 0;
        dp[1] = price[0];
        
        for(int i = 2;i<=n;i++)
        {
            int max = Integer.MIN_VALUE;
            for(int j = 1;j<=i;j++)
            {
                int curr = price[j-1] + dp[i-j];
                max = Math.max(max,curr);
            }
            dp[i] = max;
            
            
        }
        
        return dp[n];
    }
}
