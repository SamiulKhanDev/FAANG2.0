public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    //Function to return list containing vertices in Topological order.
   
    static boolean[] vis;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       
        vis = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<V;i++)
        {
            if(vis[i]==false)
            {
                dfs(i,st,adj);
            }
        }
        
        int[] ans = new int[st.size()];
        int idx = 0;
        while(st.size()>0)
        {
            ans[idx++] = st.pop();
        }
        
        return ans;
        
    }
    
    private final static void dfs(int u,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj)
    {
        
        vis[u] = true;
        for(int v:adj.get(u))
        {
            if(vis[v]==false)
            {
                dfs(v,st,adj);
            }
        }
        
        
        st.push(u);
    }
    
    
    
}
//view second version for kahn's algo