
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * @author shanxiaokai
 * @date 2021/3/27 22:48
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }

        if (k == len) {
            return reverseList(head);
        }

        int cnt = len / k;
        p = head;
        ListNode[] firsts = new ListNode[cnt];
        ListNode[] ends = new ListNode[cnt];
        ListNode temp = null;
        for (int i = 0; i < cnt; i++) {
            for(int j = 0; j < k; j++) {
                if(j == 0 ) firsts[i] = p;
                if(j == (k - 1)) {
                    ends[i] = p;
                    temp = p;
                }
                p = p.next;
                if(j == (k - 1)) {
                    temp.next = null;
                }
            }
        }
        ListNode t = p;

        for (int i = 0; i < cnt; i++) {
            reverseList(firsts[i]);
        }


        for (int i = 0; i < cnt - 1; i++) {
            firsts[i].next = ends[i + 1];
        }

        firsts[cnt - 1].next = p;
        return ends[0];

    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;
        while (cur.next != null) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Solution sol = new Solution();
        ListNode head = Util.createLinkListR(nums);
        Util.printLinkedList(head);
        ListNode newNode = sol.reverseKGroup(head,2);
        Util.printLinkedList(newNode);
    }

}
