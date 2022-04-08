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
        
        
        for(int i = 0;i<m;i++)
        {
            if(target==matrix[i][n-1]) return true;
            else if(target<matrix[i][n-1])
            {
                return binarySearch(matrix[i],0,n-1,target);
            }
        }
        
        return false;
        
    }
    
    private boolean binarySearch(int[] nums,int lo,int hi,int tar)
    {
        
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(nums[mid]==tar) return true;
            if(nums[mid]<tar) lo=mid+1;
            else hi = mid-1;
        }
        
        return false;
    }
}
