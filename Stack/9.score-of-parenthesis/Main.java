public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int scoreOfParentheses(String s)
    {
        
        int len  =s.length();
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
                int count = 0;
                while(st.size()>0 && st.peek()<0)
                {
                    int val = -st.pop();
                    val = 2*val;
                    count+=val;
                }
                st.pop();
                if(count==0)
                {
                    st.push(-1);
                }
                else
                {
                    st.push(-count);
                }
                
                
            }
        }
        
        
        int sum = 0;
        while(st.size()>0)
        {
            sum += st.pop(); 
        }
        
        
        return -sum;
    }
}
