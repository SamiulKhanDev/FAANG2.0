public class Main {
    public static void main(String[] args) {

    }

}
class Solution
 {
    static long minTime(int[] arr,int n,int k)
    {
        long sum = getSum(arr);
        long lo = 0l;
        long hi = sum;
        long ans = 0l;
        while(lo<=hi)
        {
            long mid = hi - (hi-lo)/2;
            
            if(isPossible(n,arr,k,mid))
            {
                ans = mid;
                hi = mid-1;
            }
            else
            {
                lo = mid+1;
            }
        }
        
        
        return ans;
    }
    
    private static long getSum(int[] arr)
    {
        long sum = 0l;
        for(int ele:arr)
        {
            sum+=ele;
        }
        
        return sum;
    }
    
    private static boolean isPossible(int n,int[] arr,int k,long limit)
    {
        
        int i = 0;
        long sum = 0l;
        while(i<n)
        {
            if(sum+arr[i]<=limit)
            {
                sum+=arr[i];
            }
            else
            {
                if(k==1) return false;
                k--;
                sum = arr[i];
                if(sum>limit) return false;
            }
            i++;
        }
        
        
        return true;
        
        
    }
    
    
    
}



