public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int minOperations(String[] logs)
    {
        
        int count = 0;
        for(String log:logs)
        {
            if(log.charAt(0)!='.')
            {
                count++;
            }
            else if(log.length()==3)
            {
                if(count>0)
                {
                    count--;
                }
                
            }
        }
        if(count<=0) return 0;
        return count;
        
    }
}
