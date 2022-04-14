public class Main {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private class Pair
    {
        int i;
        int j;
        int dist;
        Pair(int i,int j,int dist)
        {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        boolean[][] vis = new boolean[m][n];
        while(queue.isEmpty()==false)
        {
            Pair rem = queue.poll();
            int i = rem.i;
            int j = rem.j;
            if(vis[i][j]) continue;
            vis[i][j] = true;
            int dist = rem.dist;
            mat[i][j] = dist;
            
            for(int[] dir:dirs)
            {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni<0 || nj<0 || ni>=m || nj>=n || mat[ni][nj]==0 || vis[ni][nj]) continue;
                queue.add(new Pair(ni,nj,dist+1));
            }
            
            
        }
        
        return mat;
        
        
        
        
    }
}