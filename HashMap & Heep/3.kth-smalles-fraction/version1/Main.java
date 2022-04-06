public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> {

            double val1 = a[0] * 1.0 / a[1];
            double val2 = b[0] * 1.0 / b[1];

            return Double.compare(val2, val1);
        });

        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (maxheap.size() < k) {
                    maxheap.add(new int[] { arr[i], arr[j] });
                } else {
                    int[] top = maxheap.peek();
                    double val1 = top[0] * 1.0 / top[1];
                    double val2 = arr[i] * 1.0 / arr[j];

                    if (Double.compare(val1, val2) > 0) {
                        maxheap.poll();
                        maxheap.add(new int[] { arr[i], arr[j] });
                    }

                }
            }
        }

        return maxheap.peek();

    }
}

//this problem has many solutions,  https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
