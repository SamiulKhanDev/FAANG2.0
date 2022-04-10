import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    private static ListNode reverse(ListNode node)
    {
        if(node==null || node.next==null) return node;
        
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null)
        {
            ListNode forw = curr.next;
            curr.next = prev;
            prev =  curr;
            curr = forw;
        }
        
        
        return prev;
        
        
    }
    
    private static ListNode mid(ListNode head)
    {
        if(head==null || head.next==null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next !=null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        return slow;
        
    }

    public static void fold(ListNode head)
    {
        if(head==null || head.next==null) return ;
        ListNode mid = mid(head);
        ListNode nh = mid.next;
        mid.next = null;
        nh = reverse(nh);
        
        ListNode c1 = head;
        ListNode c2 = nh;
        while(c1!=null && c2!=null)
        {
            ListNode n1 = c1.next;
            ListNode n2 = c2.next;
            
            c1.next = c2;
            c2.next = n1;
            
            c1 = n1;
            c2 = n2;
            
        }
        if(c1!=null)
        {
            c1.next = null;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}
