public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public boolean carPooling(int[][] trips, int capacity)
    {
        
        int[] range = new int[1001];
        for(int[] trip :trips)
        {
            int nop = trip[0];
            int sp = trip[1];
            int ep = trip[2];
            
            range[sp] += nop;
            if(ep<1001)
            {
                range[ep] += -nop;
            }
            
        }
        
        int sum = 0;
        for(int i = 0;i<=1000;i++)
        {
           
            sum+=range[i];
            if(sum>capacity) return false;
        }
        
        return true;
    }
}
