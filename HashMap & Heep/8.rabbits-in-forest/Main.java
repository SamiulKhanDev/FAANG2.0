public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int numRabbits(int[] answers)
    {
        
        HashMap<Integer,Integer> fmap = new HashMap<>();
        for(int ans:answers)
        {
            int prev = fmap.getOrDefault(ans,0);
            fmap.put(ans,prev+1);
        }
        
        int count = 0;
        for(int key:fmap.keySet())
        {
            int val = fmap.get(key);
            int ceil = (int)Math.ceil(val*1.0/(key+1));
            count += (ceil*(key+1));
        }
        
        
        return count;
    }
}
