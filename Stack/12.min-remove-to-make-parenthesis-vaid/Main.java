public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public String minRemoveToMakeValid(String s)
    {
        int len = s.length();
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                st.push(i);
            }
            else if(ch==')')
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
        
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = len-1;i>=0;i--)
        {
            if(st.size()>0 && st.peek()==i)
            {
                st.pop();
            }
            else
            {
                sb.insert(0,s.charAt(i));
            }
        }
        
        
        return sb.toString();
        
        
    }
}
