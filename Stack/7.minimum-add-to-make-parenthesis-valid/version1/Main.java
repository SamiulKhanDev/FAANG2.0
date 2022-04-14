public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int minAddToMakeValid(String s)
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
        
        
        return st.size();
        
        
    }
}
