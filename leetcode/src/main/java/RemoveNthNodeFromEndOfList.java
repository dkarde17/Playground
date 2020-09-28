import util.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 36.8 MB, less than 99.97% of Java online submissions for Remove Nth Node From End of List.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int size = 1;
        int curr = 0;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            ++curr;
            size += 2;
        }
        if(fast.next != null)
            ++size;
        if(n > size/2) {
            ListNode head2 = head;
            for(int i = 0; i < size - n - 1; i++) {
                head2 = head2.next;
            }
            if(size == n)
                head = head.next;
            else if(head2.next != null)
                head2.next = head2.next.next;
            else head = null;
        } else {
            int targetIndex = size - n;
            while(curr < targetIndex - 1) {
                ++curr;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}
