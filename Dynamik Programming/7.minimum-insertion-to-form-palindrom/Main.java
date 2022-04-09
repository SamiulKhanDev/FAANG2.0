public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution{
    static int countMin(String str)
    {
        return str.length()-getLongestPlaindrom(str);
    }
    
    private  static int getLongestPlaindrom(String s)
    {
        int len = s.length(),max = 0;
        int[][] dp = new int[len][len];
        for(int g = 0;g<len;g++)
        {
            for(int i = 0,j = g;j<len;j++,i++)
            {
                if(g==0)
                {
                    dp[i][j] = 1;
                }
                else if(g==1)
                {
                    if(s.charAt(i)==s.charAt(j))
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
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j] = dp[i+1][j-1]+2;
                    }
                    else
                    {
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
                
                
            }
        }
        
        return dp[0][len-1];
    }
    
    
}