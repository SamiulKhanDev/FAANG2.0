import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1==null && l2==null) return l1;
        
        ListNode d = new ListNode(-1);
        ListNode itr = d;
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val)
            {
                itr.next = c1;
                c1 = c1.next;
            }
            else
            {
                itr.next = c2;
                c2 = c2.next;
            }
            itr = itr.next;
        }
        d = d.next;
        if(c1==null && c2==null)
        {
            return d;
        }
        else if(c1==null)
        {
            itr.next = c2;
        }
        else if(c2==null)
        {
            itr.next = c1;
        }
        
        return d;
        
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        int m = scn.nextInt();
        ListNode h2 = createList(m);


        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}