public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    private HashSet<String> vis;
    private int[][] coordinates;
    private String ans = "123450";
    public int slidingPuzzle(int[][] board) 
    {
        vis = new HashSet<>();    
        coordinates = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int ans =solve(board);
        return ans;
    }
    
    public int solve(int[][] board)
    {
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(board);
        int m = board.length;
        int n = board[0].length;
        int count = -1;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            count++;
            while(size-->0)
            {
                int[][] poll = queue.poll();
                String str = toString(poll);
                if(str.equals(ans)) return count;
                if(vis.contains(str)) continue;
                vis.add(str);
                
                int[] zero = findZeroCoordinates(poll);
                int i = zero[0];
                int j = zero[1];
                for(int[] coordinate:coordinates)
                {
                    int ni = i + coordinate[0];
                    int nj = j + coordinate[1];
                    
                    if(ni<0||nj<0||ni>=m||nj>=n) continue;
                    int[][] fc = copyBoard(poll);
                    swap(fc,i,j,ni,nj);
                    queue.add(fc);
                }
               
                
            }
        }
        
        return -1;
    }
    
    public int[] findZeroCoordinates(int[][] board)
    {
        int m  = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(board[i][j]==0) return new int[]{i,j};
            }
        }
        
        return new int[]{-1,-1};
    }
    
    public String toString(int[][] board)
    {
        StringBuilder sb = new StringBuilder();
        for(int[] row:board)
        {
            for(int col:row)
            {
                 sb.append(col);
            }
        }
        
        return sb.toString();
    }
    
    public void swap(int[][] fc,int i,int j,int ni,int nj)
    {
        int temp = fc[i][j];
        fc[i][j] = fc[ni][nj];
        fc[ni][nj] = temp;
    }
    
    public int[][] copyBoard(int[][]board)
    {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                newBoard[i][j] = board[i][j];
            }
        }
        
        return newBoard;
    }
}
