import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Compute {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        int len = (int)(n);
        long[] max = new long[len];
        long sum = 0l;
        for(int i = 0;i<n;i++)
        {
            long num = a[i];
            if(sum>=0)
            {
                sum+=num;
            }
            else
            {
                sum = num;
                
            }
            max[i] = sum;
        }
        
        
        
        long currMax = Long.MIN_VALUE;
        long window = 0l;
        for(int i = 0;i<(int)k;i++)
        {
            window += a[i];
        }
        
        currMax = Math.max(currMax,window);
        
        for(int i = (int)k;i<n;i++)
        {
            window -= a[(int)(i-k)];
            window += a[i];
            currMax = Math.max(currMax,window);
            currMax = Math.max(currMax,window+max[(int)(i-k)]);
            
        }
        
        
        return currMax;
        
        
    }
}
