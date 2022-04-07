public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    public String removeOuterParentheses(String s)
    {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i = 0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                if(st.size()>0)
                {
                    sb.append(ch);
                }
                st.push(ch);
                
            }
            else
            {
                st.pop();
                if(st.size()>0)
                {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}