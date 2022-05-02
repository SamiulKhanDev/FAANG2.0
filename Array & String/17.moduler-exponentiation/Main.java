public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution
{
    public long PowMod(long x, long n, long m)
    {
        return pow(x,n,m);
    }
    public long pow(long x,long n,long mod)
    {
        if(n==0l) return 1l;
        
        long fac = pow(x,n/2,mod);
        long temp = (fac*fac)%mod;
        if(n%2!=0)
        {
            temp*=x;
            temp%=mod;
        }
        
        return temp;
    }
    
    public long pow_iterative(long x,long n,long m)
    {
        long ans = 1l;
        x%=m;
        while(n>1)
        {
            if((n&1)!=0)
            {
                ans = (ans*x)%m;
            }
            
            x = (x*x)%m;
            n = n>>1;
            
        }
        
        return ans;
    }
    
    
}
