

import java.util.*;
import java.lang.*;
import java.io.*;


public class Main
{
    
    private static ArrayList<int[]>[] graph;
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		graph = new ArrayList[n];
		
		for(int i = 0;i<n;i++)
		{
		    graph[i] = new ArrayList<>();
		}
		
		
		
		while(m-->0)
		{
		    int u = scan.nextInt()-1;
		    int v = scan.nextInt()-1;
		    graph[u].add(new int[]{v,0});
		    graph[v].add(new int[]{u,1});
		}
		
		PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->{
		    return Integer.compare(a[1],b[1]);
		    
		});
		
		minheap.add(new int[]{0,0});
		boolean[] vis = new boolean[n];
		while(minheap.isEmpty()==false)
		{
		    int[] curr = minheap.poll();
		    int ver = curr[0],cost = curr[1];
		    if(ver==n-1)
		    {
		        System.out.println(cost);
		        return;
		    }
		    
		    if(vis[ver]) continue;
		    vis[ver] = true;
		    for(int[] edge:graph[ver])
		    {
		        if(vis[edge[0]]==false)
		        {
		            minheap.add(new int[]{edge[0],cost+edge[1]});
		        }
		    }
		    
		}
		
		System.out.println(-1);
		
		
	}
}
