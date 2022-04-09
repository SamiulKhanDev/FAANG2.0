public class Main {
    public static void main(String[] args) {

    }
}
class Solution
{
    public int nextGreaterElement(int n)
    {
        char[] str = String.valueOf(n).toCharArray();
        
        int len = str.length;
        int idx = -1;
        boolean f1 = false;
        for(int i = len-2;i>=0;i--)
        {
            for(int j = len-1;j>i;j--)
            {
                if(str[i]-'0'<str[j]-'0')
                {
                    f1 = true;
                    swap(str,i,j);
                    idx = i;
                    break;
                }
            }
            if(f1) break;
        }
        
        if(idx==-1) return -1;
        idx++;
        int j = len-1;
        while(idx<=j)
        {
            swap(str,idx,j);
            idx++;
            j--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character ch:str)
        {
            sb.append(ch);
        }
        
        long val = Long.parseLong(sb.toString());
        if(val>Integer.MAX_VALUE) return -1;
        
        return (int)(val);
        
        
        
    }
    
    private final void swap(char[] str,int i,int j)
    {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    
    
}
