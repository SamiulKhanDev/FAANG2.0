public class Main
{
    public static void main(String[] args) {
        
    }
}

// https://www.lintcode.com/problem/860/?msclkid=1061f49dc46c11ec88321607e8864a1e
public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */

    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}; 
    public int numberofDistinctIslands(int[][] grid)
    {
        int m = grid.length;
        int n =grid[0].length;
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    StringBuilder sb = new StringBuilder();
                    getShape(i,j,grid,sb);
                    
                    if(set.contains(sb.toString())==false)
                    {
                        set.add(sb.toString());
                        count++;
                    }
                }
            }
        } 
        return count;
    }

    private void getShape(int i,int j,int[][] grid,StringBuilder sb )
    {

        sb.append(grid[i][j]);
        grid[i][j] = -1;
        for(int[] dir:dirs)
        {
            int ni = i+ dir[0];
            int nj = j+ dir[1];
            if(ni<0 || nj<0 || ni>=grid.length||nj>=grid[0].length||grid[ni][nj]==-1||grid[ni][nj]==0)
            {
                sb.append(".");
                continue;
            }

            getShape(ni,nj,grid,sb);
        }

        sb.append("#");



    }
}

