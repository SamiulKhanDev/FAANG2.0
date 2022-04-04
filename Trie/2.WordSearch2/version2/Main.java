public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private class TrieNode
    {
        TrieNode[] children;
        boolean isEnd;
        String str;
        TrieNode()
        {
            this.children = new TrieNode[26];
            this.isEnd = false;
            
        }
    }
    
    private class Trie
    {
        
        
        public TrieNode root;
        Trie()
        {
            this.root = new TrieNode();
        }
        
        
        public void insert(String word)
        {
            int len = word.length();
            TrieNode curr = this.root;
            for(int i = 0;i<len;i++)
            {
                char ch = word.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isEnd = true;
            curr.str = word;
        }
        
    }
    
    
    
    public List<String> findWords(char[][] board, String[] words)
    {
        List<String> ans = new ArrayList<>();
        Trie tt = new Trie();
        int m = board.length,n = board[0].length;
        for(String s:words)
        {
            tt.insert(s);
        }
        
        
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                char ch = board[i][j];
                if(tt.root.children[ch-'a']!=null)
                {
                    dfs(board,i,j,tt.root.children[ch-'a'],ans);
                }
            }
        }
        
        HashSet<String> set = new HashSet<>();
        for(String s:ans)
        {
            set.add(s);
        }
        ans = new ArrayList<>();
        for(String s:set)
        {
            ans.add(s);
        }
        
        
        return ans;
    }
    
    private final void dfs(char[][] board,int i,int j,TrieNode root,List<String>list)
    {
        
        if(root.str!=null)
        {
            list.add(root.str);
        }
        
        char ch = board[i][j];
        board[i][j] = '#';
        
        for(int[] dir:dirs)
        {
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            
            if(ni<0 || nj<0 || ni>=board.length || nj>=board[0].length || board[ni][nj]=='#') continue;
            char nch = board[ni][nj];
            if(root.children[nch-'a']==null) continue;
            dfs(board,ni,nj,root.children[nch-'a'],list);
        }
        
        
        board[i][j] =ch;
        
        return ;
        
        
        
    }
  
}
//this is the trie implementation,if you haven't read about it please consider watch https://www.youtube.com/watch?v=BN-SUKeOYC0&list=PL-Jc9J83PIiHgzR2UIDD7MI2ABIIZztON&index=1&t=1212s
