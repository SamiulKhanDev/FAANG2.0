public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution
{
    private  ArrayList<Integer>[] graph;
    private int[] level;
    public boolean isBipartite(int[][] edges)
    {
        int n = edges.length;
        graph = new ArrayList[n];
        for(int i = 0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0;i<n;i++)
        {
            int[] edge = edges[i];
            for(int v:edge)
            {
                graph[i].add(v);
                graph[v].add(i);
            }
        }
        
        level = new int[n];
        Arrays.fill(level,-1);
        for(int i = 0;i<n;i++)
        {
            if(level[i]==-1)
            {
                if(bfs(i)==false) return false;
            }
        }
        return true;
    }
    
    private final boolean bfs(int v)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{v,0});
        while(queue.isEmpty()==false)
        {
            int size = queue.size();
          
            while(size-->0)
            {
                int[] rem = queue.poll();
                int ver = rem[0];
                int lev = rem[1];
                if(level[ver]!=-1 && level[ver]!=lev) return false;
                
                level[ver] = lev;
                
                for(int neigh:graph[ver])
                {
                    if(level[neigh]==-1)
                    {
                        queue.add(new int[]{neigh,lev+1});
                    }
                }
                
            }
        }
        
        return true;
    }
    
    
}

//refer to version 2 of the solution where i have used dfs (graph coloring technique) to solve this problem;