import java.util.*;
public class Main
{
    private static ArrayList<Integer>[] graph;
    private static Stack<Integer> st;
    private static boolean[] vis;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		graph = new ArrayList[n];
		vis = new boolean[n];
		st = new Stack<>();
		for(int i = 0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        while(m-->0)
        {
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;
            graph[u].add(v);
        }
        for(int i = 0;i<n;i++)
        {
            if(vis[i]==false)
            {
                dfs(i);
            }
        }
        
        graph = converGraph(n);
        vis = new boolean[n];
        int[] isPossible = new int[n];
        while(st.size()>0)
        {
            int ver = st.pop();
            if(vis[ver]==false)
            {
                
                int count = getAllNodes(ver,isPossible);
                if(count==1)
                {
                    isPossible[ver] = 0;
                }
            }
        }
        
        for(int ele:isPossible)
        {
            System.out.print(ele+" ");
        }
        
        
	}
	
	private static int getAllNodes(int src,int[] isPossible)
	{
	    isPossible[src] = 1;
	    int count = 1;
	    vis[src] = true;
	    for(int nbr:graph[src])
	    {
	        if(vis[nbr]==false)
	        {
	            count+=getAllNodes(nbr,isPossible);
	        }
	    }
	    return count;
	}
	
	
	private static ArrayList<Integer>[] converGraph(int n)
	{
	    ArrayList<Integer>[] ng = new ArrayList[n];
	    for(int i = 0;i<n;i++)
        {
            ng[i] = new ArrayList<>();
        }
        
        for(int i =0;i<n;i++)
        {
            ArrayList<Integer> nbrs = graph[i];
            for(int nbr:nbrs)
            {
                ng[nbr].add(i);
            }
        }
        return ng;
	}
	
	
	private static void dfs(int src)
	{
	    
	    vis[src] = true;
	    for(int nbr:graph[src])
	    {
	        if(vis[nbr]==false)
	        {
	            dfs(nbr,store);
	        }
	    }
	    st.push(src);
	}
}
