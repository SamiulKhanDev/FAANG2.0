import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{
    public static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] arr = str.split(" ");
		int n = Integer.parseInt(arr[0]);
		int q = Integer.parseInt(arr[1]);
		graph = new ArrayList[n];
		for(int i = 0;i<n;i++)
		{
		    graph[i] = new ArrayList<>();
		}
		
		while(q-->0)
		{
		    String[] query = br.readLine().split(" ");
		    if(query.length==3)
		    {
		        int u = Integer.parseInt(query[1])-1;
		        int v = Integer.parseInt(query[2])-1;
		        graph[u].add(v);
		        graph[v].add(u);
		    }
		    else
		    {
		        int src = Integer.parseInt(query[1])-1;
		        System.out.println(getDistance(n,src));
		    }
		}
	}
	
	public static int getDistance(int n,int src)
	{
	    int max = 0;
	    boolean[] vis = new boolean[n];
	    PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->{
	        return Integer.compare(b[1],a[1]);
	    });
	    maxheap.add(new int[]{src,0});
	    while(maxheap.size()>0)
	    {
	        int[] rem = maxheap.poll();
	        int ver = rem[0];
	        int dist = rem[1];
	        max = Math.max(max,dist);
	        if(vis[ver]) continue;
	        vis[ver] = true;
	        
	        for(int nbr:graph[ver])
	        {
	            if(vis[nbr]==false)
	            {
	                maxheap.add(new int[]{nbr,dist+1});
	            }
	        }
	    }
	    
	    return max;
	    
	}
	
	
}
