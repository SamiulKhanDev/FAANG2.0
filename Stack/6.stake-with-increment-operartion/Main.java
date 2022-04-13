public class Main {
    public static void main(String[] args) {

    }
}

class CustomStack
{
    
    private int[] stake;
    private int cap;
    private int front;
    private int rare;

    public CustomStack(int maxSize)
    {
        this.cap = maxSize;
        this.stake = new int[this.cap];
        this.front = 0;
        this.rare = 0;
    }
    
    public void push(int x)
    {
        if(this.rare!=this.cap)
        {
            this.stake[this.rare] = x;
            this.rare++;
        }
    }
    
    public int pop()
    {
        if(this.rare!=this.front)
        {
            this.rare--;
        }
        else
        {
            return -1;
        }
        
        return this.stake[this.rare];
        
    }
    
    public void increment(int k, int val)
    {
        for(int i = this.front;i<this.rare && i<k;i++)
        {
            this.stake[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
