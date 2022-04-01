public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution
{
    public void customSort (int phy[], int chem[], int math[], int n)
    {
        
        int[][] marks = new int[n][3];
        
        for(int i = 0;i<n;i++)
        {
            marks[i][0] = phy[i];
            marks[i][1] = chem[i];
            marks[i][2] = math[i];
        }
        
        
        Arrays.sort(marks,(a,b)->{
            if(a[0]!=b[0])
            {
                return Integer.compare(a[0],b[0]);
            }
            else if(a[1]!=b[1])
            {
                return Integer.compare(b[1],a[1]);
            }
            else
            {
                return Integer.compare(a[2],b[2]);
            }
        });
        
        
        for(int i = 0;i<n;i++)
        {
            phy[i] = marks[i][0];
            chem[i] = marks[i][1];
            math[i] = marks[i][2];
        }
        
    }
}
