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
        int i = 0;
        int j = 0;
        while(i<len)
        {
            st.push(pushed[i]);
            while(st.size()>0 && st.peek()==popped[j])
            {
                st.pop();
                j++;
            }
            i++;
        }
        
        return st.size()==0;
    }
}