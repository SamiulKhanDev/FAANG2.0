public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int minAddToMakeValid(String s)
    {
        
        int len = s.length();
        int open = 0;
        int close = 0;
        for(int i = 0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                close++;
            }
            else
            {
                if(close>0)
                {
                    close--;
                }
                else
                {
                    open++;
                }
            }
        }
        
        
        return open+close;
        
        
        
    }
}
