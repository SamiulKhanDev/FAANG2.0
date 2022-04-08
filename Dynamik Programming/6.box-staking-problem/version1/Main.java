public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static class Pair {
        int height;
        int width;
        int length;

        Pair(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int ht = height[i];
            int wt = width[i];
            int len = length[i];
            pairs.add(new Pair(ht, wt, len));
            pairs.add(new Pair(wt, ht, len));
            pairs.add(new Pair(wt, len, ht));
            pairs.add(new Pair(len, wt, ht));
            pairs.add(new Pair(len, ht, wt));
            pairs.add(new Pair(ht, len, wt));
        }
        Collections.sort(pairs, (a, b) -> {

            return Integer.compare(a.length * a.width, b.length * b.width);

        });
        int size = pairs.size();
        int[] lis = new int[size];
        int omax = 0;
        for (int i = 0; i < size; i++) {
            int max = 0;
            Pair curr = pairs.get(i);
            for (int j = i - 1; j >= 0; j--) {
                Pair com = pairs.get(j);
                if (curr.width > com.width && curr.length > com.length) {
                    max = Math.max(max, lis[j]);
                }
            }

            lis[i] = max + curr.height;
            omax = Math.max(omax, lis[i]);

        }

        return omax;

    }
}

//you surely can use a 2d array with row size as 6*n and col size as 3

