public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ele:asteroids)
        {
            if(ele>0) st.push(ele);
            else
            {
                while(st.size()>0 && st.peek()>0 && st.peek()<-ele)
                {
                    st.pop();
                }
                
                if(st.size()>0 && st.peek()>0 && st.peek()==-ele)
                {
                    st.pop();
                    continue;
                }
                if(st.size()>0 && st.peek()>0 && st.peek()>-ele)
                {
                    continue;
                }
                st.push(ele);
                
            }
        }
        
        int[] ans = new int[st.size()];
        int idx = ans.length-1;
        while(st.size()>0)
        {
            ans[idx] = st.pop();
            idx--;
        }
        return ans;
        
    }
}
