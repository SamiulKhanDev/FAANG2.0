public class Main {
    public static void main(String[] args) {

    }
}

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = Arrays.stream(arr).sum();
        if(sum%2!=0) return 0;
        int target = sum/2;
        int[][] memo = new int[N+1][target+1];
       
            for(int[] od:memo )
            {
                Arrays.fill(od,-1);
            }
        
        return isPossible(N,arr,0,target,memo);
    }
    
    public static int isPossible(int n,int[] arr,int i,int target,int[][] memo)
    {
        if(target==0) return 1;
        if(i>=n)
        {
            if(target==0) return 1;
            return 0;
        }
        
        if(memo[i][target] !=-1) return memo[i][target];
        
        
        if(target-arr[i]>=0)
        {
            int set1 = isPossible(n,arr,i+1,target-arr[i],memo);
            if(set1==1)
            {
                return memo[i][target] = 1;
            }
        }
        
        
        int set2 = isPossible(n,arr,i+1,target,memo);
        if(set2==1)
        {
            return memo[i][target] = 1;
        }
        return memo[i][target] = 0;
    }
}

//accepted
