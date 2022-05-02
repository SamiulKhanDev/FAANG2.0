public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    private ArrayList<Integer>[] graph;
    private int[] degree;
    private int[] count;
    private int[] ans;
    public int[] sumOfDistancesInTree(int n, int[][] edges)
    {
        graph = new ArrayList[n];
        degree = new int[n];
        count = new int[n];
        ans = new int[n];
        if(edges.length==0) return ans;
        for(int i = 0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges)
        {
            int u = edge[0],v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        // int root = getRoot(n);
        // postOrder(n,root,-1);
        // preOrder(n,root,-1);
        // return ans;
        postOrder(n,0,-1);
        preOrder(n,0,-1);
        return ans;
    }
    
    private void postOrder(int n,int root,int parent)
    {
        for(int nbr:graph[root])
        {
            if(nbr!=parent)
            {
                postOrder(n,nbr,root);
                count[root] += count[nbr];
                ans[root] += ans[nbr] + count[nbr];
            }
        }
        count[root]++;
    }
    
    
    private void preOrder(int n,int root,int parent)
    {
        for(int nbr:graph[root])
        {
            if(nbr!=parent)
            {
                ans[nbr]  = ans[root] + (n-count[nbr]) - count[nbr];
                preOrder(n,nbr,root);
            }
        }
    }

    private int getRoot(int n)
    {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++)
        {
            if(degree[i]==1)
            {
                queue.add(i);
            }
        }
        
        while(queue.size()>2)
        {
            int curr = queue.poll();
            
            for(int nbr:graph[curr])
            {
                degree[nbr]--;
                if(degree[nbr]==1) 
                {
                    queue.add(nbr);
                }
            }
        }
        
        return queue.poll();
    }
    
}
