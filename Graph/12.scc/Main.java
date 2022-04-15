public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    private Stack<Integer> st;
    private boolean[] vis;
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        st = new Stack<>();
        vis = new boolean[v];
        for(int i = 0;i<v;i++)
        {
            if(vis[i]==false)
            {
                dfs(adj,i);
            }
        }
        adj = convertGraph(v,adj);
        int count = 0;
        vis = new boolean[v];
        while(st.size()>0)
        {
            int vtx = st.pop();
            if(vis[vtx]==false)
            {
                count++;
                dfs(adj,vtx);
            }
        }
        return count;
    }
    
    private ArrayList<ArrayList<Integer>> convertGraph(int v, ArrayList<ArrayList<Integer>> adj)
    {

        ArrayList<ArrayList<Integer>> nadj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            nadj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int nbr : adj.get(i)) {
                nadj.get(nbr).add(i);
            }
        }
        return nadj;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj,int src)
    {
        vis[src] = true;
        for(int nbr:adj.get(src))
        {
            if(vis[nbr]==false)
            {
                dfs(adj,nbr);
            }
        }
        st.push(src);
    }
}

