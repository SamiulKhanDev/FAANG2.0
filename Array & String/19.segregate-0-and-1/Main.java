public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    void segregate0and1(int[] arr, int n)
    {
        int i=0,j=0;
        while(j<n)
        {
            if(arr[j]==0)
            {
                swap(arr,i,j);
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
    }
    
    
    private void swap(int[]arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

