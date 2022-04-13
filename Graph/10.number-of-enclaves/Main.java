public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numEnclaves(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i==0 || j==0 || i==m-1||j==n-1)
                {
                    if(grid[i][j]==1)
                    {
                        dfs(grid,i,j);
                    }
                }
            }
        }
        
        
       int count = 0;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == 1) count++;
            }
        }
        
        return count;
        
    }
    
    
    private void dfs(int[][] grid,int i,int j)
    {
        
        grid[i][j] = -1;
        
        
        for(int[] dir:dirs)
        {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni<0 || nj<0 || ni>=grid.length || nj>=grid[0].length || grid[ni][nj]==-1 || grid[ni][nj]==0) continue;
            
            dfs(grid,ni,nj);
        }
        
    }
}
