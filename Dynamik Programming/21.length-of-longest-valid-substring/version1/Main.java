public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static int findMaxLen(String s) 
    {
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<len;i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(i);
            }
            else
            {
                if(st.size()>0 && s.charAt(st.peek())=='(')
                {
                    st.pop();
                }
                else
                {
                    st.push(i);
                }
            }
            
        }
        
        int max = Integer.MIN_VALUE;
        int idx = len;
        while(st.size()>0)
        {
            max = Math.max(max,idx-st.peek()-1);
            idx = st.pop();
        }
        
        max = Math.max(max,idx-0);
        return max;
        
        
        
    }
};
