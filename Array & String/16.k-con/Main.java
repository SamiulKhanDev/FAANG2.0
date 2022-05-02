/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static Reader scan;
	public static void main (String[] args) throws java.lang.Exception
	{
		scan = new Reader();
		int t = scan.nextInt();
		while(t-->0)
		{
		    try {
		        solve();
		    } catch(Exception e) {
		    }
		}
	}
	private static void solve() throws Exception
	{
	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    int[] nums = new int[n];
	    for(int i = 0;i<n;i++)
	    {
	        nums[i] = scan.nextInt();
	    }
	    
	    long sum = getSum(nums);
	    int[] con = getConcatinatedArray(nums);
	    long max = getMax(con);
	    if(k==1)
	    {
	        System.out.println(getMax(nums));
	        return;
	    }
	    if(sum<=0l)
	    {
	        System.out.println(max);
	    }
	    else
	    {
	        System.out.println(max+(k-2)*sum);
	    }
	    
	    
	}
	
	private static long getSum(int[] nums)
	{
	    long sum = 0l;
	    for(int num:nums)
	    {
	        sum+= num;
	    }
	    return sum;
	}
	
	private static int[] getConcatinatedArray(int[] nums)
	{
	    int n = nums.length;
	    int[] narr = new int[2*n];
	    int idx = 0;
	    int i = 0;
	    while(idx<narr.length)
	    {
	        narr[idx++] = nums[i++];
	        if(i>=nums.length)
	        {
	            i = 0;
	        }
	    }
	    
	    return narr;
	}
	
	
	private static long getMax(int[] nums)
	{
	    long max = Long.MIN_VALUE;
	    long sum = 0l;
	    for(int num:nums)
	    {
	        if(sum>=0)
	        {
	            sum+=num;
	        }
	        else
	        {
	            sum = num;
	        }
	        max = Math.max(max,sum);
	    }
	    return max;
	}
	
	
	
	//custom scanner class
	static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
 
}
