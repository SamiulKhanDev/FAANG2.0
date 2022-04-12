public class Main {
    public static void main(String[] args) {
        
    }
}


class Solution
{
    private int[] indegree;
    private ArrayList<Integer>[] graph;
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        indegree = new int[numCourses];
        graph = new ArrayList[numCourses];
        int[] ans = new int[numCourses];
        for(int i = 0;i<numCourses;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites)
        {
            int first = prerequisite[1];
            int second = prerequisite[0];
            graph[first].add(second);
            indegree[second]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }
        
        
        boolean[] vis = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        int n = 0;
        while(queue.isEmpty()==false)
        {
            int curr = queue.poll();
            if(vis[curr]) continue;
            vis[curr] = true;
            n++;
            st.push(curr);
            
            for(int neigh:graph[curr])
            {
                indegree[neigh]--;
                if(indegree[neigh]==0)
                {
                    queue.add(neigh);
                }
            }
            
        }
        if(n!=numCourses) return new int[]{};
        
        int idx = st.size()-1;
        while(st.size()>0)
        {
            ans[idx--] = st.pop();
        }
        
        return ans;
        
        
    }
}