

class ListNode
    {
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
        }
    }

public class Main 
{

    
    public static void main(String[] args)
    {

        

    }
}

class Solution
{

    public ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null)
        {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    } 



}



