public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>>adj)
    {
        
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];
        for(int i = 0;i<v;i++){
            if(vis[i]==false){
                dfs(adj,i,vis,st);
            }
        }
        
        int pv = st.pop();
        int count = 0;
        vis = new boolean[v];
        for(int i = 0;i<v;i++){
            if(vis[i]==false){
                dfs(adj,i,vis);
                count++;
            }
        }
        
        return count==1?pv:-1;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>>adj,int src,boolean[]vis,Stack<Integer> st){
        
        
        vis[src] = true;
        for(int ele:adj.get(src)){
            if(vis[ele]==false){
                dfs(adj,ele,vis,st);
            }
        }
        
        st.push(src);
        
    }
    public static void dfs(ArrayList<ArrayList<Integer>>adj,int src,boolean[]vis){
        
        
        vis[src] = true;
        for(int ele:adj.get(src)){
            if(vis[ele]==false){
                dfs(adj,ele,vis);
            }
        }
        
      
        
    }
    
}
