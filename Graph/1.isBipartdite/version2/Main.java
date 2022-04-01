public class Main {
    public static void main(String[] args) 
    {


        
    }
}


class Solution 
{
    
    private int[] colors;
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        colors = new int[n];
        for(int i = 0;i<n;i++)
        {
            if(colors[i]== 0 && dfs(graph,i,1)==false) return false;
        }
        
        return true;
        
    }
    
    
    private final boolean dfs(int[][] edges,int ver,int color)
    {

        colors[ver] = color;
        for (int neigh : edges[ver]) {
            if (colors[neigh] == -color)
                continue;
            if (colors[neigh] == color || dfs(edges, neigh, -color) == false)
                return false;
        }

        return true;
    }
    private final boolean bfs(int[][] edges,int i)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,1});
        
        while(queue.size()>0)
        {
            int[] rem = queue.poll();
            int ver = rem[0],color = rem[1];
            if(colors[ver]!=0 && colors[ver]!=color) return false;
            colors[ver] = color;
            for(int neigh:edges[ver])
            {
                if(colors[neigh]==0)
                {
                    queue.add(new int[]{neigh,-color});
                }
            }
        }
        return true;
    }
    
}