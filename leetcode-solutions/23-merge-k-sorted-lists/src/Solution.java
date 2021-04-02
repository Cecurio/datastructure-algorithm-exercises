/**
 * @author shanxiaokai
 * @date 2021/3/23 10:53
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int low = 0;
        int high = lists.length - 1;
        return merge(lists, low, high);
    }

    ListNode merge(ListNode[] lists, int low, int high) {
        if (low == high) return lists[low];
        int mid = low + (high - low) / 2;
        ListNode h1 = merge(lists, low, mid);
        ListNode h2 = merge(lists, mid + 1, high);
        return mergeTwoLinkList(h1, h2);
    }

    ListNode mergeTwoLinkList(ListNode h1, ListNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        ListNode mainLink = h1;

        ListNode p = h1;
        ListNode q = h2;
        ListNode pre = null;

        while (p != null && q != null) {
            if (p.val > q.val) {
                ListNode temp = q;
                q = q.next;
                if (pre == null) {
                    temp.next = p;
                    pre = temp;
                    mainLink = temp;
                } else {
                    temp.next = p;
                    pre.next = temp;
                    pre = temp;
                }
            } else {
                pre = p;
                p = p.next;
            }
        }

        if (q != null) {
            pre.next = q;
        }
        return mainLink;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = Util.createLinkListR(arr);
//        Util.printLinkedList(head);
//        Util.printLinkedList(head);

        ListNode[] lists = new ListNode[3];
        //[[1,4,5],[1,3,4],[2,6]]
        lists[0] = Util.createLinkListR(new int[]{1, 4, 5});
        lists[1] = Util.createLinkListR(new int[]{1, 3, 4});
        lists[2] = Util.createLinkListR(new int[]{2, 6});

        Solution sol = new Solution();
        ListNode newKNode = sol.mergeKLists(lists);
        Util.printLinkedList(newKNode);
        System.out.println("done");

//        ListNode n = mergeTwoLinkList(lists[0], lists[1]);
//        Util.printLinkedList(n);

    }
}
