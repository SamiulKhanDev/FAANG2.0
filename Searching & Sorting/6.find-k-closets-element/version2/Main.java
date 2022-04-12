public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        
        List<Integer> list = new ArrayList<>();
        
        int len = arr.length;
        int lo = 0;
        int hi = len-1;
        int mid = 0;
        while(lo<=hi)
        {
            mid = hi - (hi-lo)/2;
            
            if(arr[mid]==x) break;
            if(arr[mid]<x)
            {
                lo = mid+1;
            }
            else
            {
                hi = mid-1;
            }
        }
        
        int i = mid;
        int j = mid+1;
        
        while((i>=0 || j<len) && k>0)
        {
            int diff1 = (i>=0?Math.abs(arr[i]-x):Integer.MAX_VALUE);
            int diff2 = (j<len?Math.abs(arr[j]-x):Integer.MAX_VALUE);
            if(diff1<=diff2)
            {
                list.add(arr[i]);
                i--;
            }
            else
            {
                list.add(arr[j]);
                j++;
            }
            k--;
        }
        
        Collections.sort(list);
        return list;
        
    }
}
