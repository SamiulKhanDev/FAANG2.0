import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int v = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);

    int[] wells = new int[v];
    String[] words = br.readLine().split(" ");

    for (int i = 0; i < wells.length; i++) {
      wells[i] = Integer.parseInt(words[i]);
    }

    int[][] pipes = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st1 = br.readLine().split(" ");
      pipes[i][0] = Integer.parseInt(st1[0]);
      pipes[i][1] = Integer.parseInt(st1[1]);
      pipes[i][2] = Integer.parseInt(st1[2]);

    }

    System.out.println(minCostToSupplyWater(v, wells, pipes));

  }
  
  private static class Pair implements Comparable<Pair>
  {
      int ai;
      int bi;
      int wt;
      Pair(int ai,int bi,int wt)
      {
          this.ai = ai;
          this.bi = bi;
          this.wt = wt;
      }
      
      @Override
      public int compareTo(Pair o)
      {
          return this.wt - o.wt;
      }
  }
  
  private static int[] parent;
  private static  int[] rank;
  
  public static int findParent(int u)
  {
      if(parent[u]==u) return u;
      int temp = findParent(parent[u]);
      parent[u] = temp;
      return temp;
  }
  public static void union(int u,int v)
  {
      if(rank[u]>rank[v])
      {
         parent[v] = u; 
      }
      else if(rank[u]<rank[v])
      {
          parent[u] = v;
      }
      else
      {
         parent[v] = u; 
         rank[u]++;
      }
  }

  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) 
  {
       int pl = pipes.length; 
       parent = new int[n+1];
       rank = new int[n+1];
       for(int i = 0;i<=n;i++)
       {
           parent[i] = i;
           rank[i] = 0;
       }
       Pair[] pairs = new Pair[n+pl];
       int idx = 0;
       for(int i = 1;i<=n;i++)
       {
           Pair np = new Pair(0,i,wells[i-1]);
           pairs[idx++] = np;
       }
       
       for(int[]pipe:pipes)
       {
           Pair np = new Pair(pipe[0],pipe[1],pipe[2]);
           pairs[idx++] = np;
       }
       
       Arrays.sort(pairs);
       int ans = 0;
       for(Pair sp:pairs)
       {
           int u = sp.ai;
           int v = sp.bi;
           
           u = findParent(u);
           v = findParent(v);
           if(u!=v)
           {
               union(u,v);
               ans+=sp.wt;
           }
       }
       
    return ans;
  }
}