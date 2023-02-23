import util.ListNode;

/**
 *iven the head of a singly linked list, reverse the list, and return the
 * reversed list.
 *
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        if(head == null)
            return head;
        while(head.next != null) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        head.next = prevNode;
        return head;
    }
}
