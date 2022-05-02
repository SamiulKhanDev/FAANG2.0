import java.util.*;

public class Main {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int minJumps(int x) 
    {
        int jump = 1;
        int sum = 0;
        while(sum<x)
        {
            sum += jump;
            if(sum<x)
            {
                jump++;
            }
        }
        
        int dis = sum - x;
        if(dis==0) return jump;
        else if(dis%2==0) return jump;
        else
        {
            if(jump%2==0) return jump+1;
            return jump+2;
        }
    }

    //~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}