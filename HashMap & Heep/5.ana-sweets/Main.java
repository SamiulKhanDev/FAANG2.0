public class Main
{
    public static void main(String[] args) {
        
    }
}


class Solution{
    static int isPossible(int N, int arr[], int k)
    {
        int[] freq = new int[33];
        for(int num:arr)
        {
            freq[num]++;
        }
        
        for(int num:freq)
        {
            if(num>0)
            {
                int quo = (int)Math.ceil((num*1.0/2));
                if(quo>k) return 0;
            }
        }
        
        
        return 1;
    }
}