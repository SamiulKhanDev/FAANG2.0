public class Main {
    public static void main(String[] args) {

    }
}

class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        long[][] memo = new long[n][n];
        for(long[] od:memo)
        {
            Arrays.fill(od,-1l);
        }
        long ans = solve(arr,0,n-1,memo);
        return ans;
    }
    
    public static long solve(int[] arr,int i,int j,long[][]memo)
    {
        
        // if(i>j) return 0l;
        if(i>j) return 0l;
        
        if(memo[i][j] !=-1l) return memo[i][j] ;
        
        long f1 = solve(arr,i+2,j,memo);
        long f2 = solve(arr,i+1,j-1,memo);
        long f3 = solve(arr,i,j-2,memo);
        
        long val1 = (long)arr[i] + Math.min(f1,f2);
        long val2 = (long)arr[j] + Math.min(f2,f3);
        
        return memo[i][j] = Math.max(val1,val2);
        
        
        
        
    }
    
    
}

