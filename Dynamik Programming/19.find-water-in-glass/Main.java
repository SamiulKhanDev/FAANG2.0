

public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution
{
    static double waterOverflow(int K, int R, int C)
    {
        double[][] dp = new double[R+1][R+1];
        dp[0][0] = K*1.0;
        
        for(int i = 0;i<dp.length-1;i++)
        {
            for(int j = 0;j<=i;j++)
            {
                if(dp[i][j]>1.0)
                {
                    double  extra = dp[i][j] - 1.0;
                    dp[i][j] = 1.0;
                    dp[i+1][j] += extra/2;
                    dp[i+1][j+1] +=extra/2; 
                }
            }
        }
        return dp[R-1][C-1];
    }
}