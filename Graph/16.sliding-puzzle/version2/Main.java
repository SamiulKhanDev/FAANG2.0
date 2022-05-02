public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution
{
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private int MOD = Integer.MAX_VALUE;
    private int ans = getCode("1#2#3#4#5#0");
    public int slidingPuzzle(int[][] board)
    {
        
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(board);
        int level = -1;
        while(queue.size()>0)
        {
            int size = queue.size();
            level++;
            while(size-->0)
            {
                int[][] rem = queue.poll();
                String curr = getString(rem);
                // System.out.println(curr);
                int hc = getCode(curr);
                if(hc==ans) return level;
                if(visited.contains(hc)) continue;
                visited.add(hc);
                int[] zero = getZeroIndex(rem);
                for(int[] dir:dirs)
                {
                    int i = zero[0] + dir[0];
                    int j = zero[1] + dir[1];
                    
                    if(i<0 || j<0 || i>=board.length||j>=board[0].length) continue;
                    int[][] nr = swap(zero,new int[]{i,j},rem);
                    if(visited.contains(getCode(getString(nr)))) continue;
                    queue.add(nr);
                }
            }
        }
        
        return -1;
        
    }
    
    private int[][] swap(int[] zero,int[] curr,int[][] board)
    {
        int[][] nr = new int[2][3];
        for(int i = 0;i<board.length;i++)
        {
            for(int j = 0 ;j<board[0].length;j++)
            {
                nr[i][j] = board[i][j];
            }
        }
        
        nr[zero[0]][zero[1]] = board[curr[0]][curr[1]];
        nr[curr[0]][curr[1]] = 0;
        return nr;
        
        
    }
    
    private int getCode(String str)
    {
        return Math.abs(str.hashCode())%MOD;
    }
    
    private String getString(int[][] board)
    {
        return board[0][0]+"#"+board[0][1]+"#"+board[0][2]+"#"+board[1][0]+"#"+board[1][1]+"#"+board[1][2];
    }
    
    private int[] getZeroIndex(int[][] board)
    {
        for(int i = 0;i<board.length;i++)
        {
            for(int j = 0 ;j<board[0].length;j++)
            {
                if(board[i][j]==0)
                {
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[]{-1,-1};
    }
    
    
}