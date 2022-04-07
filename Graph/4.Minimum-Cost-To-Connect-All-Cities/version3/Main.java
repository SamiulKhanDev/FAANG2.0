public class Main {
    public static void main(String[] args) {

    }
}
class Solution
{
    public int minCostConnectPoints(int[][] points) 
    {
        int len = points.length;
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        boolean[] vis = new boolean[len];
        
        int cost = 0,n=0;
        minheap.add(new int[]{0,0});
        while(minheap.size()>0)
        {
            int[] curr = minheap.poll();
            int idx = curr[0];
            int[] point = points[idx];
            int currCost = curr[1];
            if(vis[idx]) continue;
            n++;
            cost+=currCost;
            if(n==len) return cost;
            
            vis[idx] = true;
            for(int i = 0;i<len;i++)
            {
                if(i!=idx)
                {
                    int[] to = points[i];
                    int diss = Math.abs(to[0]-point[0]) + Math.abs(to[1]-point[1]);
                    minheap.add(new int[]{i,diss});
                }
            }
            
        }
        
        return -1;
        
    }
}
