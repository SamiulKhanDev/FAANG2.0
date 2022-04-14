public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    //Function to find maximum number of consecutive steps 
    //to gain an increase in altitude with each step.
    static int maxStep(int a[], int n)
    {
        int max = 0;
        int count = 0;
        for(int i = 1;i<n;i++)
        {
            if(a[i-1]<a[i])
            {
                count++;
                max = Math.max(max,count);
            }
            else
            {
                count = 0;
            }
        }
        
        return max;
    }
    
}
