public class Main {
    public static void main(String[] args) {

    }
}

class Sol
{
    int isPossible (String S)
    {
        int[] freq = new int[26];
        
        for(char ch:S.toCharArray())
        {
            freq[ch-'a']++;
        }
        
        boolean odd = false;
        for(int i = 0;i<26;i++)
        {
            if(freq[i]%2!=0)
            {
                if(odd) return 0;
                odd = true;
            }
        }
        
        return 1;
    }
}
