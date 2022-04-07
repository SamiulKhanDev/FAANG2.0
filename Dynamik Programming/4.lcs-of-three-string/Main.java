public class Main {
    public static void main(String[] args) {
        
    }
}

class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        
        int[][][] memo = new int[n1+1][n2+1][n3+1];
        for(int[][] td:memo)
        {
            for(int[] od:td)
            {
                Arrays.fill(od,-1);
            }
        }
        
        return solve(A,B,C,0,0,0,memo);
    }
    
    private int getMax(int...args)
    {
        int max = Integer.MIN_VALUE;
        for(int ele:args)
        {
            max = Math.max(max,ele);
        }
        return max;
    }
    
    private final int solve(String a,String b,String c,int i,int j,int k,int[][][] memo)
    {
        if(i>=a.length() || j>=b.length() || k>=c.length())
        {
            return 0;
        }
        if(memo[i][j][k]!=-1) return memo[i][j][k];
        
        char ch1 = a.charAt(i);
        char ch2 = b.charAt(j);
        char ch3 = c.charAt(k);
        int max = 0;
        if(ch1==ch2 && ch2==ch3)
        {
            int include = 1 + solve(a,b,c,i+1,j+1,k+1,memo);
            max = include;
        }
        else
        {
            int ch1exclude = solve(a,b,c,i+1,j,k,memo);
            int ch2exclude = solve(a,b,c,i,j+1,k,memo);
            int ch3exclude = solve(a,b,c,i,j,k+1,memo);
            max = getMax(ch1exclude,ch2exclude,ch3exclude);
        }
        
        return memo[i][j][k] = max;
        
        
    }
    
    
} 
