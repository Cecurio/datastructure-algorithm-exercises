/**
 * @author shanxiaokai
 * @date 2021/3/23 10:56
 */
public class Util {

    static ListNode createLinkListR(int[] arr) {
        assert(arr.length >= 1);
        ListNode head = new ListNode(arr[0]);
        ListNode rear = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            rear.next = newNode;
            rear = newNode;
        }
        rear.next = null;
        return head;
    }

    static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
