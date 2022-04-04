public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int[] nextGreaterElements(int[] nums)
    {
        
        int len = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = len-2;i>=0;i--)
        {
            st.push(i);
        }
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        for(int i = len-1;i>=0;i--)
        {
            int num = nums[i];
            while(st.size()>0 && i!= st.peek() && num>=nums[st.peek()])
            {
                st.pop();
            }
            
            if(st.size()>0 && st.peek()!=i)
            {
                ans[i] = nums[st.peek()];
            }
            
            st.push(i);
            
        }
        
        return ans;
        
    }
}
