import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int e = scan.nextInt();
        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++)
            parent[i] = i;
        int[][] edges = new int[e][3];
        int i = 0;
        while (e-- > 0) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            edges[i][0] = from;
            edges[i][1] = to;
            edges[i][2] = cost;
            i++;
        }

        Arrays.sort(edges, (a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        int cost = 0;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                cost += edge[2];
            }

        }

        System.out.println(cost);

    }

    private static int findParent(int u) {
        if (parent[u] == u)
            return u;

        return parent[u] = findParent(parent[u]);
    }

    private static boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return false;

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }

        return true;
    }

}
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/minimum-cost-to-connect-all-cities-official/ojquestion
//this question has another type with the dots... refer version 2(https://leetcode.com/problems/min-cost-to-connect-all-points/)
