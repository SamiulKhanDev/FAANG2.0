public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    
    private long mod = (long)(1e9+7);
	public long getCount(int n)
	{
		HashMap<Integer,int[]> map = new HashMap<>();
		
		map.put(0,new int[]{0,8});
		map.put(1,new int[]{1,2,4});
		map.put(2,new int[]{2,1,3,5});
		map.put(3,new int[]{3,2,6});
		map.put(4,new int[]{4,1,5,7});
		map.put(5,new int[]{5,2,8,4,6});
		map.put(6,new int[]{6,3,5,9});
		map.put(7,new int[]{7,4,8});
		map.put(8,new int[]{0,8,7,9,5});
		map.put(9,new int[]{9,6,8});
		long[][] dp = new long[n+1][10];
		for(int i = 1;i<=n;i++)
		{
		    for(int j = 0;j<10;j++)
		    {
		        if(i==1)
		        {
		            dp[i][j] = 1l;
		        }
		        else
		        {
		            int[] nbrs = map.get(j);
		            for(int nbr:nbrs)
		            {
		                
		                dp[i][j] += dp[i-1][nbr]; 
		            }
		        }
		    }
		}
		long sum = 0l;
		for(int i = 0;i<10;i++)
		{
		    sum+= dp[n][i];
		}
		
		return sum;
	}
}
