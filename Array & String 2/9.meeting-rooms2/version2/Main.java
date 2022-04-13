import java.util.*;


public class Main 
{
    public static void print(int[] nums)
    {
        for(int num:nums)
        {
            System.out.print(num+" ");
        }
        System.out.println();
    }
  public static int meetingRooms(int intervals[][]) 
  {
    int n = intervals.length;
    int[] stps = new int[n];
    int[] endps = new int[n];
    int idx = 0;
    for(int[] interval:intervals)
    {
        stps[idx] = interval[0];
        endps[idx] = interval[1];
        idx++;
        
    }
    
    Arrays.sort(stps);
    Arrays.sort(endps);
    int maxMeeting = 0;
    int rooms = 0;
    
    int i = 0,j=0;
    while(i<n && j<n)
    {
        if(stps[i]<endps[j])
        {
            maxMeeting++;
            i++;
        }
        else
        {
            maxMeeting--;
            j++;
        }
        // System.out.println(rooms+" "+maxMeeting);
        rooms = Math.max(maxMeeting,rooms);
    }
    
    return rooms;
    
  }
  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);

    // Input Format
    int n = scn.nextInt();
    int input[][] = new int[n][2];

    for (int i = 0 ; i <  n ; i++) {
      int sp = scn.nextInt();
      int ep = scn.nextInt();

      input[i][0] = sp;
      input[i][1] = ep;
    }

    // Output Format
    System.out.println(meetingRooms(input));
  }
}