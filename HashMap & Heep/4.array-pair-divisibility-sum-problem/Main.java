public class Main
{
    public static void main(String[] args) {
        
    }
}
class Solution
{
    public boolean canPair(int[] nums, int k) 
    {
        int[] freq = new int[k];
        
        for(int num:nums)
        {
            freq[num%k]++;
        }
        
        for(int i = 0;i<k;i++)
        {
            if(i==0 || 2*i==k)
            {
                if(freq[i]%2!=0) return false;
            }
            else
            {
                int ith = freq[i];
                int kmith = freq[k-i];
                
                if(ith!=kmith) return false;
            }
        }
        
        
        return true;
        
        
    }
}

//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/check-if-an-array-cab-be-divided-into-pairs-whose-sum-is-divisible-by-k-official/ojquestion