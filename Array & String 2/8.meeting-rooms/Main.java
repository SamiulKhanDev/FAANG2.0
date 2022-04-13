import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;


public class Main{
    public static boolean meetingRooms(int intervals[][])
    {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        
        
        Stack<int[]> st = new Stack<>();
        for(int[] interval:intervals)
        {
            if(st.size()==0)
            {
                st.push(interval);
            }
            else
            {
                int[] top = st.peek();
                if(top[1]<=interval[0])
                {
                    st.push(interval);
                }
                else
                {
                    return false;
                }
            }
        }
        
        
        return true;
        
        
        
        
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for(int i = 0 ; i <  n ; i++){
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}