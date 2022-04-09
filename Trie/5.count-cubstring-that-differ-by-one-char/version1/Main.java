public class Main {
    public static void main(String[] args) {
        
    }
}


class Solution
{
    public int countSubstrings(String s, String t)
    {
        
        int slen = s.length();
        int tlen = t.length();
        int res =0;
        for(int i = 0;i<slen;i++)
        {
            for(int j = 0;j<tlen;j++)
            {
                int miss = 0;
                for(int p = 0;i+p<slen && j+p<tlen;p++)
                {
                    if(s.charAt(i+p)!=t.charAt(j+p) && ++miss>1)
                    {
                        break;
                    }
                    
                    res+=miss;
                    
                }
            }
        }
        
        return res;
        
    }
}