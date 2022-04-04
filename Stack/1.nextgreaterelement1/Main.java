public class Main {
    public static void main(String[] args) {
        
    }
}

class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        HashMap<Integer,Integer> imap = new HashMap<>();
        int n = nums2.length;
        for(int i = 0;i<n;i++)
        {
            imap.put(nums2[i],i);
        }
        
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++)
        {
            int num = nums2[i];
            while(st.size()>0 && nums2[st.peek()]<num)
            {
                nge[st.pop()] = i;
            }
            
            st.push(i);
            
            
        }
        
        int[] ans = new int[nums1.length];
        int idx = 0;
        for(int q:nums1)
        {
            int id = imap.get(q);
            ans[idx++] = (nge[id]==-1?-1:nums2[nge[id]]);
        }
        
        return ans;
    }
}