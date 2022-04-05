public class Main {
    public static void main(String[] args) {

    }
}
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<n && j<m)
        {
            int num1 = arr1[i];
            int num2 = arr2[j];
            if(num1==num2)
            {
                addEle(ans,num1);
                i++;
                j++;
            }
            else if(num1<num2)
            {
                addEle(ans,num1);
                i++;
            }
            else
            {
                addEle(ans,num2);
                j++;
            }
        }
        
        while(i<n)
        {
            addEle(ans,arr1[i]);
            i++;
        }
        while(j<m)
        {
            addEle(ans,arr2[j]);
            j++;
        }
        
        
        return ans;
    }
    
    private static final void addEle(ArrayList<Integer>ans,int num)
    {
        if(ans.size()>0)
        {
            if(ans.get(ans.size()-1)!=num)
            {
                ans.add(num);
            }
        }
        else
        {
             ans.add(num);
        }
    }
    
    
    
}




