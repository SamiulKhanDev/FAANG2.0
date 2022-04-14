public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    private HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        set = new HashSet<>();
        for(String str:wordDict)
        {
            set.add(str);
        }
        
        int[]memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return isPossible(s,0,memo);
    }
    
    public boolean isPossible(String s,int i,int[]memo)
    {
        
        if(i>=s.length()) return true;
        if(memo[i]!=-1) return (memo[i]==0?false:true);
        for(int k = i;k<s.length();k++)
        {
            String prefix = s.substring(i,k+1);
            if(set.contains(prefix))
            {
                if(isPossible(s,k+1,memo)) return true;
            }
        }
        
        memo[i] = 0;
        return  false;
        
    }
    
    
    
}
