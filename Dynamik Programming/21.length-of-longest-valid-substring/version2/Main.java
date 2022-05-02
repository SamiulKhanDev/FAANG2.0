public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static int findMaxLen(String s)
    {
        int len = s.length();
        int open = 0,close = 0,max = 0;
        for(int i = 0;i<len;i++)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                close++;
            }
            
            
            if(open==close)
            {
                max = Math.max(max,open+close);
            }
            else if(close>open)
            {
                open=close=0;
            }
            
            
        }
        open=close=0;
        for(int i = len-1;i>=0;i--)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                close++;
            }
            
            
            if(open==close)
            {
                max = Math.max(max,open+close);
            }
            else if(open>close)
            {
                open=close=0;
            }
        }
        
        return max;
    }
};
