public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int[] exclusiveTime(int n, List<String> logs)
    {
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        //[id,start,childTime];
        
        for(String log:logs)
        {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type =parts[1];
            int time = Integer.parseInt(parts[2]);
            
            if(type.equals("start"))
            {
                st.push(new int[]{id,time,0});
            }
            else
            {
                int[] top = st.pop();
                int interval = time-top[1]+1-top[2];
                int rt = time-top[1]+1;
                ans[id]+= interval;
                if(st.size()>0)
                {
                    st.peek()[2]+=rt;
                }
                
            }
           
        }
        
        
        return ans;
        
    }
}
