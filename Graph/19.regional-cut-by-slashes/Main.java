public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int regionsBySlashes(String[] grid)
    {
        int n = grid.length;
        int dc = n+1;
        int dots = (n+1)*(n+1);
        UnionFind uf = new UnionFind(dots,n+1);
        int count = 1;
        for(int i = 0;i<n;i++)
        {
            char[] row = grid[i].toCharArray();
            for(int j = 0;j<n;j++)
            {
                if(row[j]=='\\')
                {
                    int d1 = i*dc+(j);
                    int d2 = (i+1)*dc+(j+1);
                    if(uf.union(d1,d2))
                    {
                        count++;
                    }
                }
                else if(row[j]=='/')
                {
                    int d1 = i*dc+(j+1);
                    int d2 = (i+1)*dc+j;
                    if(uf.union(d1,d2))
                    {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private class UnionFind
    {
        private int[] parent;
        private int[] rank;
        UnionFind(int dots,int n)
        {
            this.parent = new int[dots];
            this.rank = new int[dots];
            for(int i = 0;i<dots;i++)
            {
                this.parent[i] = i;
            }
            
            connectEdges(n);
            
        }
        
        private void connectEdges(int n)
        {
            for(int i = 0;i<n;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    if(i==0 || j==0 || i==n-1||j==n-1)
                    {
                        int dn = i*n+j;
                        if(dn!=0)
                        {
                            union(0,dn); 
                        }
                    }
                }
            }
        }
        
        private int findParent(int i)
        {
            if(this.parent[i]==i) return i;
            
            return parent[i] = findParent(parent[i]);
        }
        
        public boolean union(int u,int v)
        {
            u = findParent(u);
            v = findParent(v);
            
            if(u!=v)
            {
                if(rank[u]>rank[v])
                {
                    parent[v] = u;
                }
                else if(rank[v]>rank[u])
                {
                    parent[u] = v;
                }
                else
                {
                    parent[v] = u;
                    rank[u]++;
                }
                return false;
            }
            else
            {
                return true;
            }
        }
        
        
        
        
        
    }
    
    
}
