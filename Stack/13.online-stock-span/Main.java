public class Main {
    public static void main(String[] args) {

    }
}

class StockSpanner
{
    
    private int idx;
    private Stack<int[]> st; 

    public StockSpanner()
    {
        this.idx = -1;
        this.st = new Stack<>();
    }
    
    public int next(int price)
    {
        this.idx++;
        while(st.size()>0 && st.peek()[0]<=price)
        {
            st.pop();
        }
        
        int gap = this.idx - (st.size()==0?-1:st.peek()[1]);
        st.push(new int[]{price,idx});
        return gap;
        
        
    }
}
