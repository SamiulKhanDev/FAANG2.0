public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public Node connect(Node root)
    {
        if(root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        while(queue.isEmpty()==false)
        {
            int size = queue.size();
            Queue<Node> cq = new LinkedList<>();
            while(size-->0)
            {
                Node rem = queue.poll();
               
                if(queue.size()>0)
                {
                    rem.next = queue.peek();
                }
                if(rem.left!=null)
                {
                    cq.add(rem.left);
                }
                if(rem.right!=null)
                {
                    cq.add(rem.right);
                }
            }
            
            queue = cq;
        }
        
        return root;
        
    }
}
