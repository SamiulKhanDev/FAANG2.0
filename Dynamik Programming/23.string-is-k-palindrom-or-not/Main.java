public class Main {
    public static void main(String[] args) {

    }
}

class Solution{
    static int kPalindrome(String str, int n, int k)
    {
        int[][] dp = new int[n][n];
        int max = 0;
        for(int g = 0;g<n;g++)
        {
            for(int i = 0,j = g;j<n;j++,i++)
            {
                if(g==0)
                {
                    dp[i][j] = 1;
                }
                else if(g==1)
                {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    if(ch1==ch2)
                    {
                        dp[i][j] = 2;
                    }
                    else
                    {
                        dp[i][j] = 1;
                    }
                }
                else
                {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    if(ch1==ch2)
                    {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                    else
                    {
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        
        int delete = n-dp[0][n-1];
        
        
        return delete<=k?1:0;
        
    }
}
