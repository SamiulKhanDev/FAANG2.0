public class Main {
    public static void main(String[] args) {

    }
}
class Solution
{
    public boolean isLongPressedName(String name, String typed)
    {
        int lenOfName = name.length();
        int lenOftyped = typed.length();
        int i = 0,j=0;
        while(i<lenOfName && j<lenOftyped)
        {
            char chname = name.charAt(i);
            char chtyped = typed.charAt(j);
            if(chname==chtyped)
            {
                i++;
                j++;
            }
            else
            {
                if(i-1>=0 && name.charAt(i-1)==chtyped)
                {
                    j++;
                }
                else
                {
                    return false;
                }
            }
        }
        
        
        while(j<lenOftyped)
        {
            if(name.charAt(lenOfName-1)!=typed.charAt(j))
            {
                return false;
            }
            j++;
        }
        
        if(i<lenOfName) return false;
        
        return true;
    }
}
