public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int max = 0;
        for(Job j:arr)
        {
            max = Math.max(max,j.deadline);
        }
        
        int[] time = new int[max+1];
        Arrays.fill(time,-1);
        Arrays.sort(arr,(a,b)->{
            return Integer.compare(b.profit,a.profit);
        });
        
        
        int count = 0,totalProfit = 0;
        for(Job j:arr)
        {
            if(time[j.deadline]==-1)
            {
                count++;
                totalProfit+= j.profit;
                time[j.deadline] = j.id;
            }
            else
            {
                for(int k = j.deadline-1;k>=1;k--)
                {
                    if(time[k]==-1)
                    {
                        count++;
                        totalProfit+= j.profit;
                        time[k] = j.id;
                        break;
                    }
                }
            }
        }
        return new int[]{count,totalProfit};
        
    }
}
