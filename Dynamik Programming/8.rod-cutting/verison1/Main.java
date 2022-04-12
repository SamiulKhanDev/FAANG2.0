public class Main {
    public static void main(String[] args) {

    }
}
class Solution{
    public int cutRod(int price[], int n)
    {
        int[][] memo = new int[n+1][n+1];
        for(int[] od:memo)Arrays.fill(od,-1);
        int ans = solve(price,1,n,memo);
    
        return ans;
    }
      public int solve(int[] prices,int cut,int len,int[][]memo)
      {
        
        if(len==0 || cut>len) return 0;
        if(memo[cut][len]!=-1) return memo[cut][len];
          
        int include = 0;
        if(len-cut>=0)
        {
            include = prices[cut-1] + solve(prices,cut,len-cut,memo);
        }
        
        int exclude = solve(prices,cut+1,len,memo);
        
        return memo[cut][len] = Math.max(include,exclude);
          
          
          
      }
}

//this is the recursive version
//for tabulation refer to version 2