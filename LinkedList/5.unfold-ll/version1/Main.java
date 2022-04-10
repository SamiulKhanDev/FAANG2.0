import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);

        ListNode oitr = oddDummy;
        ListNode eitr = evenDummy;

        ListNode itr = head;

        boolean isEven = true;

        while (itr != null) {
            if (isEven) {
                eitr.next = itr;
                eitr = eitr.next;
            } else {
                oitr.next = itr;
                oitr = oitr.next;
            }

            itr = itr.next;
            isEven = !isEven;
        }

        eitr.next = null;
        oitr.next = null;
        oddDummy = oddDummy.next;
        eitr.next = reverse(oddDummy);

        head = evenDummy.next;

    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
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
        unfold(head);
        printList(head);
    }
}

//this is not inplace, version2 is
