public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public Queue<int[]> queue;
    public int[][] updateMatrix(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;
        queue = new LinkedList<>();
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new int[]{i,j,0});
                }
            }
        }
        
        solve(mat);
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(mat[i][j]<0)
                {
                    mat[i][j] = -mat[i][j];
                }
            }
        }
        
        return mat;
    }
    
    public void solve(int[][] mat)
    {
        while(queue.isEmpty()==false)
        {
            int[] poll = queue.poll();
            
            int i = poll[0];
            int j = poll[1];
            if(mat[i][j]<0) continue;
            int dist = poll[2];
            mat[i][j] = -dist;
            
            for(int[] dir:dirs)
            {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(nr<0 || nc<0 || nr>=mat.length || nc>=mat[0].length || mat[nr][nc]<=0) continue;
                
                queue.add(new int[]{nr,nc,dist+1});
            }
        }
    }
    
}
