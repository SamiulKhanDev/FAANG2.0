import java.util.*;

public class Main
{
    public static void main(String[] args) {
        
    }
}

class Solution
{
    private void insert(Node root,Stack<Node>st)
    {
        
        while(root!=null)
        {
            st.push(root);
            root = root.left;
        }
    }
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> list = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
       
        insert(root1,s1);
        insert(root2,s2);
        while(s1.size()!=0 && s2.size()!=0)
        {
            if(s1.peek().data<=s2.peek().data)
            {
                Node rem = s1.pop();
                list.add(rem.data);
                insert(rem.right,s1);
            }
            else
            {
                Node rem = s2.pop();
                list.add(rem.data);
                insert(rem.right,s2);
            }
        }
        
        while(s1.size()!=0)
        {
            Node rem = s1.pop();
            list.add(rem.data);
            insert(rem.right,s1);
        }
        while(s2.size()!=0)
        {
            Node rem = s2.pop();
            list.add(rem.data);
            insert(rem.right,s2);
        }
        
        return list;
        
    }
}
