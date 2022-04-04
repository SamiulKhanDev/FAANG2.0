public class Main {
    public static void main(String[] args) {

    }
}
class Solution
{
    
    private HashMap<Integer,ArrayList<Integer>> busStopToBuses;
    private boolean[] busesAlreadyBoard;
    private HashSet<Integer> stationAlreadyVisited;
    public int numBusesToDestination(int[][] routes, int source, int target)
    {
        int len = routes.length;
        busStopToBuses = new HashMap<>();
        busesAlreadyBoard = new boolean[len];
        stationAlreadyVisited = new HashSet<>();
        for(int bidx = 0;bidx<len;bidx++)
        {
            //bidx->bus index
            int[] stations = routes[bidx];//stations where this bus goes
            for(int station:stations)
            {
                ArrayList<Integer> listOfBusesThatGoesFromThisStation =  busStopToBuses.getOrDefault(station,new ArrayList<>());
                listOfBusesThatGoesFromThisStation.add(bidx);
                busStopToBuses.put(station,listOfBusesThatGoesFromThisStation);
            }
        }
        
        
        Queue<int[]> queue = new LinkedList<>();//[currentStation,number of buses board to reach here];
        
        queue.add(new int[]{source,0});
        
        while(queue.isEmpty()==false)
        {
            int[] currStation = queue.poll();
            int stationNumber = currStation[0],busBoard = currStation[1];
            if(stationNumber==target) return busBoard;
            
            if(stationAlreadyVisited.contains(stationNumber)) continue;
            stationAlreadyVisited.add(stationNumber);
            for(int bus:busStopToBuses.get(stationNumber))
            {
                if(busesAlreadyBoard[bus]==false)
                {
                    busesAlreadyBoard[bus] = true;
                    for(int station:routes[bus])
                    {
                        queue.add(new int[]{station,busBoard+1});
                    }
                }
            }
            
            
        }
        
        return -1;
        
        
    }
}
