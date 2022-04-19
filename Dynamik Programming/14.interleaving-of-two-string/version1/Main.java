public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    public boolean isInterleave(String s1, String s2, String s3) 
    {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int[][] memo = new int[s1.length()][s2.length()];
        for(int[] od:memo)
        {
            Arrays.fill(od,-1);
        }
        return isInterleave(s1,s2,s3,0,0,memo);
    }
    private boolean isInterleave(String s1,String s2,String s3,int i,int j,int[][] memo)
    {
        
        if(i+j>=s3.length() )
        {
            if(i==s1.length() && j==s2.length()) return true;
            return false;
        }
        if(i==s1.length() || j==s2.length())
        {
            if(i!=s1.length())
            {
                return s1.substring(i).equals(s3.substring(i+j));
            }
            if(j!=s2.length())
            {
                return s2.substring(j).equals(s3.substring(i+j));
            }
            
            return false;
            
        }
        if( memo[i][j]!=-1) return (memo[i][j]==0?false:true);
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        char ch3 = s3.charAt(i+j);
        if(ch1==ch3)
        {
            if(isInterleave(s1,s2,s3,i+1,j,memo))
            {
                memo[i][j] = 1;
                return true;
            }
        }
        if(ch2==ch3)
        {
            if(isInterleave(s1,s2,s3,i,j+1,memo))
            {
                 memo[i][j] = 1;
                return true;
            }
        }
         memo[i][j] = 0;
        return false;
    }
}
