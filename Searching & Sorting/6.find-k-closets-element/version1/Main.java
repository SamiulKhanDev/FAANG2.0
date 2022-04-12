public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution
{
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->{
            int diff1 = Math.abs(b-x);
            int diff2 = Math.abs(a-x);
            if(diff1!=diff2)
            {
                return Integer.compare(diff1,diff2);   
            }
            else
            {
                return Integer.compare(b,a);
            }
        });
        
        int len = arr.length;
        for(int i = 0;i<len;i++)
        {
            int num = arr[i];
            int diff = Math.abs(num-x);
            if(maxheap.size()<k)
            {
                maxheap.add(num);
            }
            else
            {
                int peek = maxheap.peek();
                int pdiff = Math.abs(peek-x);
                if(pdiff>diff || (pdiff==diff && peek>num))
                {
                    maxheap.poll();
                    maxheap.add(num);
                }
                
            }
        }
        List<Integer> list = new ArrayList<>();
        while(maxheap.size()>0)
        {
            list.add(maxheap.poll());
        }
        
        Collections.sort(list);
        return list;
        
    }
}