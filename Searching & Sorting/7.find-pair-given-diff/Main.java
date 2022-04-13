public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        
        while(i<size && j<size && i<j)
        {
           
            int num1 = arr[i];
            int num2 = arr[j];
            int diff =num2-num1; 
            if(diff==n) return true;
            
            if(diff>n) i++;
            else j++;
            
            if(i==j)
            {
                j++;
            }
        }
        
        return false;
    }
}