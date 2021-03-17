public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre;
        dummy.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //-1->5->3->4->0
        ListNode head = new ListNode(4);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        sol.print(head);
        ListNode newHead = sol.insertionSortList(head);
        sol.print(head);
        sol.print(newHead);
    }

    void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
