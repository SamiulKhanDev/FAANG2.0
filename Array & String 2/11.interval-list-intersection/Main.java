public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList)
    {
        
        ArrayList<int[]> list = new ArrayList<>();
        int lenf = firstList.length;
        int lens = secondList.length;
        
        int i = 0,j = 0;
        while(i<lenf && j<lens)
        {
            int[] arr = new int[2];
            
            arr[0] = Math.max(firstList[i][0],secondList[j][0]);
            arr[1] = Math.min(firstList[i][1],secondList[j][1]);
            if(arr[0]<=arr[1])
            {
                list.add(arr);
            }
            
            if(firstList[i][1]<=secondList[j][1])
            {
                i++;
            }
            else
            {
                j++;
            }
            
            
            
        }
        int idx = 0;
        int[][] ans = new int[list.size()][2];
        for(int[] li:list)
        {
            ans[idx++] = li;
        }
        
        return ans;
    }
}
