public class Main {
    public static void main(String[] args) {
        
    }
}

public class Solution
{
    /**
     * @param words1: 
     * @param words2: 
     * @param pairs: 
     * @return: Whether sentences are similary or not?
     */
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
                parent[i] = i;
            }
        }

        private int getCode(String str)
        {
            int hc = str.hashCode();
            return Math.abs(hc)%parent.length;
        }

        private int findParent(int i)
        {
            if(parent[i]==i) return i;
            return parent[i] = findParent(parent[i]);
        }

        public boolean union(String str1,String str2)
        {
            int pu = findParent(getCode(str1));
            int pv = findParent(getCode(str2));

            if(pu!=pv)
            {
                if(rank[pu]>rank[pv])
                {
                    parent[pv] = pu;
                }
                else if(rank[pv]>rank[pu])
                {
                    parent[pu] = pv;
                }
                else
                {
                    parent[pv] = pu;
                    rank[pu]++;
                }
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) 
    {
        UnionFind uf = new UnionFind(4000);
        for(List<String> pair:pairs)
        {
            uf.union(pair.get(0),pair.get(1));
        }

        int len = words1.size();
        for(int i = 0;i<len;i++)
        {
            String str1 = words1.get(i);
            String str2 = words2.get(i);

            if(uf.union(str1,str2)) return false;
        }

        return true;

    }
}