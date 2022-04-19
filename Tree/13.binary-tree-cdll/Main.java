public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    public Node head;
    public Node tail;
    Node bTreeToClist(Node root)
    {
        
        // System.out.println("sam");
        head = null;
        tail = null;
        Node curr = root;
        Node prev = null;
        while(curr!=null)
        {
            
            Node leftNode = curr.left;
            if(leftNode==null)
            {
                if(head==null)
                {
                    head = curr;
                }
                if(prev!=null)
                {
                    prev.right = curr;
                    curr.left = prev;
                }
                prev = curr;
                curr = curr.right;
                // System.out.println(head.data);
                
            }
            else
            {
                Node rmn = getrightMostNode(leftNode,curr);
                if(rmn.right==null)
                {
                    rmn.right = curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right = curr;
                    curr.left = prev;
                    
                    prev = curr;
                    curr = curr.right;
                }
            }
            
            tail = prev;
            
        }
        
        tail.right = head;
        head.left = tail;
        root = head;
        // System.out.println(head.data);
        return root;
    }
    
    private static Node getrightMostNode(Node left,Node curr)
    {
        while(left.right!=null && left.right!=curr)
        {
            left = left.right;
        }
        
        return left;
    }
    
    
}
    

