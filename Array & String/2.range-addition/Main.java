public class Main {
    public static void main(String[] args) {

    }
}
public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates)
    {
        int[] arr = new int[length];

        for(int[] update:updates)
        {
            int l = update[0];
            int r = update[1];

            int num = update[2];
            arr[l] += num;
            if(r+1<length)
            {
                arr[r+1] += -num;
            }
        }


        int sum = 0;
        for(int i = 0;i<length;i++)
        {
            sum+=arr[i];
            arr[i] = sum;
        }

        return arr;
        
    }
}
