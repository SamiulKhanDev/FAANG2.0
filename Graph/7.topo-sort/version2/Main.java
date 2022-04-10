public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[V];
        int size = adj.size();
        for(int i = 0;i<size;i++)
        {
            for(int v:adj.get(i))
            {
                indegree[v]++;
            }
        }
        
        Stack<Integer> st = new Stack<>();
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }
        boolean[] vis = new boolean[V];
        int n = 0;
        while(queue.isEmpty()==false)
        {
            int curr = queue.poll();
            
            if(vis[curr]) continue;
            vis[curr] = true;
            st.add(curr);
            n++;
            for(int to:adj.get(curr))
            {
                indegree[to]--;
                if(indegree[to]==0)
                {
                    queue.add(to);
                }
            }
            
        }
        if(n!=V)
        {
            //cycle detection
            return new int[]{-1};
        }
        int idx = st.size()-1;
        int[] ans = new int[st.size()];
        while(st.size()>0)
        {
            ans[idx--] = st.pop(); 
        }
        return ans;  
    }
}

