public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0,j = n-1;
        while(i<m && j>=0)
        {
            int num = matrix[i][j];
            if(num==target) return true;
            if(num<target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        
        return false;
        
    }
}
