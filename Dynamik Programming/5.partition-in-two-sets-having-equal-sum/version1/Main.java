
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        
    }
}
class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        return isPossible(N,arr,0,0,0);
    }
    
    public static int isPossible(int n,int[] arr,int i,int sum1,int sum2)
    {
        if(i>=n)
        {
            if(sum1==sum2) return 1;
            return 0;
        }
        
        
        
        
        int set1 = isPossible(n,arr,i+1,sum1+arr[i],sum2);
        if(set1==1)
        {
            return 1;
        }
        
        
        int set2 = isPossible(n,arr,i+1,sum1,sum2+arr[i]);
        if(set2==1)
        {
            return 1;
        }
        return 0;
    }
}

//this version will give tle;