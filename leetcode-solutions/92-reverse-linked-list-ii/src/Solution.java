
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * @author shanxiaokai
 * @date 2021/3/18 13:35
 */
class Solution {
    private void print(ListNode head) {
        ListNode p = head;
        int i=0;
        while (p != null) {
            if(i++ != 0) {
                System.out.print("->");
            }
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < left; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = null;
        // 共执行 (right-left) 次
        for (int i = left; i < right; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        sol.print(head);
        ListNode newHead = sol.reverseBetween(head, 1, 5);
        sol.print(head);
        sol.print(newHead);
    }
}