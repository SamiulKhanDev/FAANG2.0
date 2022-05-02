public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public boolean find132pattern(int[] nums)
    {
        int len = nums.length;
        int[] min = Arrays.copyOf(nums,len);
        for(int i = 1;i<len;i++)
        {
            min[i] = Math.min(nums[i],min[i-1]);
        }
        
        Stack<Integer> st = new Stack<>();
        for(int i = len-1;i>=0;i--)
        {
            int currMin = min[i];
            if(currMin==nums[i]) continue;
            while(st.size()>0 && currMin>=nums[st.peek()])
            {
                st.pop();
            }
            if(st.size()>0 && nums[i]>nums[st.peek()]) return true;
            st.push(i);
        }
        
        
        return false;
        
        
    }
}
