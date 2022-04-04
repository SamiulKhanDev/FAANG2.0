public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public List<String> findWords(char[][] board, String[] words)
    {
        List<String> ans = new ArrayList<>();
        int m = board.length,n = board[0].length;
        for(String s:words)
        {
            boolean f1 = false,f2 = false;
            for(int i = 0;i<m;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    if(board[i][j]==s.charAt(0))
                    {
                     
                        boolean flag = dfs(s,1,board,i,j);
                        // System.out.println(s+" "+flag);
                        if(flag)
                        {
                            ans.add(s);
                            f1 = true;
                            f2 = true;
                        }
                        if(f1) break;
                    }
                }
                if(f2) break;
            }
        }
        
        return ans;
    }
    
    private final boolean dfs(String s,int cindex,char[][] board,int i,int j)
    {
        if(cindex==s.length()) return true;
        
        char ch = s.charAt(cindex);
        char boardCh = board[i][j];
        board[i][j] = '#';
        
        for(int[] dir:dirs)
        {
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            
            if(ni<0 || nj<0 || ni>=board.length || nj>=board[0].length || board[ni][nj]=='#' || board[ni][nj]!=ch) continue;
            if(dfs(s,cindex+1,board,ni,nj))
            {
                 board[i][j] = boardCh;
                 return true;
            }
        }
        
        
        board[i][j] = boardCh;
        
        return false;
        
        
        
    }
  
}
//this dfs code won't pass the last tc due to high time complexity(63rd tc was added to this question latter to time out the dfs solution);
//refer version 2 for the trie implementation