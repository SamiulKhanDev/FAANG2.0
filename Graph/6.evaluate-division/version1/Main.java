public class Main {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    private class Pair
    {
        String ver;
        double val;
        Pair(String ver,double val)
        {
            this.ver = ver;
            this.val = val;
        }
    }
    private HashMap<String,ArrayList<Pair>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        graph = new HashMap<>();
        int len = equations.size();
        for(int i = 0;i<len;i++)
        {
            List<String> list = equations.get(i);
            String  from = list.get(0);
            String to = list.get(1);
            
            ArrayList<Pair> prev = graph.getOrDefault(from,new ArrayList<>());
            prev.add(new Pair(to,values[i]));
            graph.put(from,prev);
            
            prev = graph.getOrDefault(to,new ArrayList<>());
            prev.add(new Pair(from,1.0/values[i]));
            graph.put(to,prev);
        }
        int size = queries.size();
        double[] ans = new double[size];
        int idx = 0;
        for(List<String> query:queries)
        {
            String from = query.get(0);
            String to = query.get(1);
            double val = getMinCost(from,to);
            ans[idx++] = val;
            
        }
        return ans;   
    }
    
    private final double getMinCost(String from,String to)
    {
        HashSet<String> set = new HashSet<>();
        if(graph.containsKey(from)==false) return -1.0;
        
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a,b)->{
            return Double.compare(a.val,b.val);
        });
        
        minheap.add(new Pair(from,1.0));
        
        
        while(minheap.isEmpty()==false)
        {
            Pair rem = minheap.poll();
            System.out.println(rem.ver);
            if(rem.ver.equals(to)) return rem.val;
            if(set.contains(rem.ver)) continue;
            set.add(rem.ver);
            
            for(Pair edge:graph.get(rem.ver))
            {
                if(set.contains(edge.ver)==false)
                {
                    minheap.add(new Pair(edge.ver,edge.val*rem.val));
                }
            }
        }
        
        
        return -1.0;
    }
}


//dijkstra algorithm