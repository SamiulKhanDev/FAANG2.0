public class Main {
    public static void main(String[] args) {

    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] meetings = new int[n][2];
        for(int i = 0;i<n;i++)
        {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        
        Arrays.sort(meetings,(a,b)->{
            if(a[1] != b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        
        int count = 1;
        int minEnd = meetings[0][1];
        for(int i = 1;i<n;i++)
        {
            if(meetings[i][0]>minEnd)
            {
                count++;
                minEnd = meetings[i][1];
            }
            
        }
        
        
        return count;
        
    }
}
//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1#
