public class Main {
    public static void main(String[] args) {

    }
}
class Solution 
{
    public int maxArea(int[] height) 
    {
        
        int n = height.length;
        int i = 0;
        int j = n-1;
        int max = 0;
        while(i<j)
        {
            int ht1 = height[i];
            int ht2 = height[j];
            int min = Math.min(ht1,ht2);
            max = Math.max(max,min*(j-i));
            if(ht1==min) i++;
            if(ht2==min) j--;
        }
        
        return max;
    }
}
