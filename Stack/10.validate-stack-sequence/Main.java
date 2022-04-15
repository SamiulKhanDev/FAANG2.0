public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public boolean validateStackSequences(int[] pushed, int[] popped)
    {
        int len = pushed.length;
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int i = 0;i<len;i++)
        {
            st.push(pushed[i]);
            while(st.size()>0 && st.peek()==popped[j])
            {
                st.pop();
                j++;
            }
        }
        
        
        return j==len;
        
    }
}
