import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    String str = scan.next();
		    System.out.println(solve(str));
		}
	}
	
	
	private static int solve(String str)
	{
	    int len = str.length();
	    int[][] dp = new int[len][len];
	    int max = 0;
	    for(int g = 0;g<len;g++)
	    {
	        for(int i = 0,j = g;j<len;j++,i++)
	        {
	            if(g==0)
	            {
	                dp[i][j] = str.charAt(i) - '0';
	               // System.out.println(dp[i][j]+" "+g);
	            }
	            else
	            {
	                int mid = (i+j)/2;
	                dp[i][j] = dp[i][mid]+dp[mid+1][j];
	                if(g%2!=0)
	                {
	                    if(dp[i][mid]==dp[mid+1][j])
    	                {
    	                    max = Math.max(max,j-i+1);
    	                }
	                }
	            }
	        }
	    }
	    return max;
	}
	
}