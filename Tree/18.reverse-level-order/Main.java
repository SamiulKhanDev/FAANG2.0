public class Main {
    public static void main(String[] args) {

    }
}


class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node==null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-->0)
            {
                Node rem = queue.poll();
                ans.add(0,rem.data);
                if(rem.right!=null)
                {
                    queue.add(rem.right);
                }
                
                if(rem.left!=null)
                {
                    queue.add(rem.left);
                }
                
            }
        }
        return ans;
    }
}      