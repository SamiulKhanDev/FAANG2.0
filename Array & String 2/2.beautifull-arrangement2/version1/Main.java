public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] constructArray(int n, int k) {

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        int l = 0;

        while (k-- > 0) {
            swap(arr, l);
            l++;
        }

        return arr;

    }

    private final void swap(int[] arr, int s) {
        int j = arr.length - 1;
        while (s < j) {
            int temp = arr[s];
            arr[s] = arr[j];
            arr[j] = temp;
            s++;
            j--;
        }
    }
}
//refer version 2 for more optimized code logic
