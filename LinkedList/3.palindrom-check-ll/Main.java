import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    

    public static boolean isPalindrome(ListNode head)
    {
        if(head==null || head.next==null) return true;
        
        ListNode mid = getMid(head);
        ListNode nh = mid.next;
        mid.next = null;
        nh = reverse(nh);
        
        
        ListNode itr1 = head;
        ListNode itr2 = nh;
        while(itr1!=null && itr2!=null)
        {
            if(itr1.val!=itr2.val) return false;
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        
        return true;
    }
    
    
    private static ListNode getMid(ListNode head)
    {
        if(head==null || head.next==null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        return slow;
    }
    
    private static ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null) return head;
        
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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        System.out.println(isPalindrome(dummy.next));
    }
}