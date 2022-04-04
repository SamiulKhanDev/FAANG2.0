public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int len = primes.length;
        int[] pointers = new int[len];

        Arrays.fill(pointers, 1);
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int p = 0; p < len; p++) {
                min = Math.min(min, primes[p] * dp[pointers[p]]);
            }

            dp[i] = min;
            for (int p = 0; p < len; p++) {
                int curr = primes[p] * dp[pointers[p]];
                if (curr == min) {
                    pointers[p]++;
                }
            }
        }

        return dp[n];

    }
}

//https://leetcode.com/problems/super-ugly-number/
