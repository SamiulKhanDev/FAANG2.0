public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public String reverseParentheses(String s)
    {
        
        int len = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(ch==')')
            {
                StringBuilder sb = new StringBuilder();
                while(st.size()>0 && st.peek()!='(')
                {
                    sb.append(st.pop());
                }
                st.pop();
                for(char sbch:sb.toString().toCharArray())
                {
                    st.push(sbch);
                }
            }
            else
            {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size()>0)
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
        
    }
}
