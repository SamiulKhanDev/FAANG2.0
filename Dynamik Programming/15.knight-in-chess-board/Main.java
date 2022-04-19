public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    
    int[][] dirs = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public double knightProbability(int n, int k, int row, int column)
    {
        double[][] board = new double[n][n];
        board[row][column] = 1.0;
        while(k-->0)
        {
            double[][] nb = new double[n][n];
            for(int i = 0;i<n;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    if(board[i][j]>0.0)
                    {
                        for(int[] dir:dirs)
                        {
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            
                            if(ni<0 || nj<0 || ni>=n || nj>=n) continue;
                            nb[ni][nj]+= (board[i][j]/8);
                        }
                    }
                }
            }
            board = nb;
        }
        
        double sum = 0.0;
        for(double [] od:board)
        {
            for(double ele:od)
            {
                sum+=ele;
            }
        }
        
        return sum;
        
        
    }
}
