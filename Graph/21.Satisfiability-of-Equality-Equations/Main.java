public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    private class UnionFind
    {
        private int[] parent;
        private int[] rank;
        UnionFind(int n)
        {
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0;i<n;i++)
            {
                this.parent[i] = i;
            }
        }
        
        private int findParent(int i)
        {
            if(parent[i]==i) return i;
            
            return parent[i] = findParent(parent[i]);
        }
        
        
        private void union(int u,int v)
        {
            if(rank[u]>rank[v])
            {
                parent[v] = u;
            }
            else if(rank[v]<rank[u])
            {
                parent[u] = v;
            }
            else
            {
                parent[v] = u;
                rank[u]++;
            }
            
        }
        
        
        
        
        
    }
    
    public boolean equationsPossible(String[] equations)
    {
        UnionFind uf = new UnionFind(26);
        for(String equation:equations)
        {
            char[] arr = equation.toCharArray();
            if(arr[1]=='=')
            {
                int u = (int)(arr[0]-'a');
                int v = (int)(arr[3]-'a');
                u = uf.findParent(u);
                v = uf.findParent(v);
                if(u!=v)
                {
                    uf.union(u,v);
                }
            }
        }
        
        for(String equation:equations)
        {
            char[] arr = equation.toCharArray();
            if(arr[1]=='!')
            {
                int u = (int)(arr[0]-'a');
                int v = (int)(arr[3]-'a');
                u = uf.findParent(u);
                v = uf.findParent(v);
                if(u==v)
                {
                    return false;
                }
            }
        }
        
        
        
        return true;
        
        
        
        
        
    }
}
