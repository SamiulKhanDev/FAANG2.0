public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private int[] parent;
    private int[] rank;

    public int minCostConnectPoints(int[][] points) {

        ArrayList<int[]> edges = new ArrayList<>();

        int len = points.length;
        parent = new int[len];
        rank = new int[len];
        for (int i = 0; i < len; i++)
            parent[i] = i;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] ith = points[i];
                int[] jth = points[j];

                int cost = Math.abs(ith[0] - jth[0]) + Math.abs(jth[1] - ith[1]);

                edges.add(new int[] { i, j, cost });
            }
        }

        Collections.sort(edges, (a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        int cost = 0;
        //this loop is good,but we know that an spanning tree will have n-1 edeges for n vertex;
        // for(int[] edge:edges)
        // {
        //     if(union(edge[0],edge[1]))
        //     {
        //         cost += edge[2];
        //     }
        // }

        //this loops better
        int size = edges.size();
        int usedEdges = 0;
        for (int i = 0; i < size && usedEdges < len - 1; i++) {
            int[] edge = edges.get(i);
            if (union(edge[0], edge[1])) {
                cost += edge[2];
                usedEdges++;
            }
        }

        return cost;

    }

    private final int findParent(int u) {
        if (parent[u] == u)
            return u;

        return parent[u] = findParent(parent[u]);
    }

    private final boolean union(int u, int v) {
        u = findParent(u);
        v = findParent(v);
        if (u == v)
            return false;
        if (rank[u] > rank[v]) {
            parent[v] = u;
        } else if (rank[u] < rank[v]) {
            parent[u] = v;
        } else {
            parent[v] = u;
            rank[u]++;
        }
        return true;
    }
}

//https://leetcode.com/problems/min-cost-to-connect-all-points/
//this one is kruskal
//refer version3 for primes
