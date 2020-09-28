package util;

public class ArrayUtils {

    public static ListNode listFromArray(int[] input) {
        ListNode head = new ListNode(input[0]);
        ListNode prev = head;
        for (int i = 1; i < input.length; i++) {
            ListNode curr = new ListNode(input[i]);
            prev.next = curr;
            prev = prev.next;
        }
        return head;
    }
}
