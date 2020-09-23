import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
     * Memory Usage: 39.5 MB, less than 71.53% of Java online submissions for Add Two Numbers.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode res = null, prev = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOver;
            l1 = l1.next;
            l2 = l2.next;
            ListNode curr = new ListNode(sum % 10);
            carryOver = sum / 10;
            if (prev == null) {
                res = curr;
            } else {
                prev.next = curr;
            }
            prev = curr;
        }
        while (l1 != null) {
            int sum = l1.val + carryOver;
            ListNode curr = new ListNode(sum % 10);
            carryOver = sum / 10;
            prev.next = curr;
            prev = curr;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carryOver;
            ListNode curr = new ListNode(sum % 10);
            carryOver = sum / 10;
            prev.next = curr;
            prev = curr;
            l2 = l2.next;
        }
        if (carryOver != 0)
            prev.next = new ListNode(carryOver);
        return res;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(0);
        ListNode l22 = new ListNode(3);
        ListNode l2 = new ListNode(7);
        l2.next = l22;
        ListNode res = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println("debug");
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
