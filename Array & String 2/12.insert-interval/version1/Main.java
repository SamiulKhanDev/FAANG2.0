public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        int len = intervals.length;
        
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while(i<len)
        {
            int[]curr = intervals[i];
            if(curr[1]<newInterval[0])
            {
                list.add(curr);
                i++;
            }
            else
            {
                break;
            }
            
        }
        
        if(i==len)
        {
            list.add(newInterval);
        }
        else
        {
            if(newInterval[0]<=intervals[i][0]&&newInterval[1]<=intervals[i][1])
            {
                list.add(newInterval);
            }
            else
            {
                int[] narr = new int[2];
                narr[0] = Math.min(intervals[i][0],newInterval[0]);
                narr[1] = Math.max(intervals[i][1],newInterval[1]);
                if(narr[0]<=narr[1])
                {
                    list.add(narr);
                }
                i++;
            }



            while(i<len)
            {
                if(list.get(list.size()-1)[1]>=intervals[i][0])
                {
                    list.get(list.size()-1)[0] = Math.min(list.get(list.size()-1)[0],intervals[i][0]);
                    list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],intervals[i][1]);
                }
                else
                {
                    list.add(intervals[i]);
                }
                i++;
            }
        }
        
        
        
        
        int[][] ans = new int[list.size()][2];
        int idx = 0;
        for(int[]interval:list)
        {
            ans[idx++] = interval;
        }
        
        return ans;
        
        
    }
}
