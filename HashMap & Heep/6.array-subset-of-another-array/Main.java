public class Main {
    public static void main(String[] args) {

    }
}
class Compute 
{
    public String isSubset( long a1[], long a2[], long n, long m) 
    {
        
        HashSet<Long> set1 = new HashSet<>();
        for(long ele:a1)
        {
            set1.add(ele);
        }
        
        
        for(long ele:a2)
        {
            if(set1.contains(ele)==false)
            {
                return "No";
            }
        }
        
        
        return "Yes";
        
    }
}
