public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        List<int[]> ones = new ArrayList<>();
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    ones.add(new int[]{i,j});
                }
            }
        }
        int xm = getMedian(ones,0);
        int ym = getMedian(ones,1);
        int ans = Integer.MAX_VALUE;
        
        int sum = 0;
        for(int[] one:ones)
        {
            sum+= Math.abs(one[0]-xm)+Math.abs(one[1]-ym);
        }

        


        return sum;
    }
    private int getMedian(List<int[]>list,int index)
    {
        Collections.sort(list,(a,b)->{
            return Integer.compare(a[index],b[index]);
        });

        return list.get(list.size()/2)[index];
    }



}
