public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b)
            {
                return Integer.compare(a[0],b[0]);
            }
        });
            
        Stack<int[]> st = new Stack<>();
        for(int[] interval:intervals)
        {
            if(st.size()>0)
            {
                int[] top = st.peek();
                if(top[1]<interval[0])
                {
                    st.push(interval);
                }
                else 
                {
                    top[1] = Math.max(top[1],interval[1]);
                }
            }
            else
            {
                st.push(interval);
            }
        }
        
        
        int[][] ans = new int[st.size()][2];
        int idx = st.size()-1;
        while(st.size()>0)
        {
            ans[idx--] = st.pop(); 
        }
        
        
        return ans;
        
    }
}