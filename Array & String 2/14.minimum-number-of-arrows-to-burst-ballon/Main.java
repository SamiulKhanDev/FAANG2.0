public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    public int findMinArrowShots(int[][] points) 
    {
        Arrays.sort(points,(a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });        
        
        
        int count = 1;
        int end = points[0][1];
        for(int i = 1;i<points.length;i++)
        {
            if(points[i][0]>end)
            {
                count++;
                end = points[i][1];
            }
        }
        
        return count;
        
    }
}
