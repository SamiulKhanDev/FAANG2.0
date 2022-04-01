import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int nthUglyNumber(int n)
    {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;

        for (int i = 2; i <= n; i++) {
            int val2 = dp[p2] * 2;
            int val3 = dp[p3] * 3;
            int val5 = dp[p5] * 5;

            int min = Math.min(val2, Math.min(val3, val5));
            dp[i] = min;
            if (min == val2) {
                p2++;
            }
            if (min == val3) {
                p3++;
            }
            if (min == val5) {
                p5++;
            }

        }
        return dp[n];
    }
    
    //solution 2 using priorityQueue(minheep);

    private final int nthUglyNumber_pqversion()
    {
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        minheap.add(1l);
        for(int i = 1;i<n;i++)
        {
            long temp = minheap.poll();
            while (minheap.isEmpty() == false && minheap.peek() == temp)
                minheap.poll();

            long val2 = 2 * temp, val3 = 3 * temp, val5 = 5 * temp;
            minheap.add(val2);
            minheap.add(val3);
            minheap.add(val5);
        }
        
        return minheap.poll().intValue();
    }

}
