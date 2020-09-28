import util.ListNode;

import static util.ArrayUtils.listFromArray;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
public class PalindromeLinkedList {


    static ListNode globalHead = null;

    /**
     * Runtime: 1 ms, faster than 96.30% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 43.2 MB, less than 48.79% of Java online submissions for Palindrome Linked List.
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        globalHead = head;
        boolean isPalindrome = true;
        if(head == null)
            return isPalindrome;
        ListNode slow = head;
        ListNode fast = head;
        int size = 1;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            size += 2;
        }
        if(fast.next != null)
            ++size;
        if(size%2 == 0) {
            isPalindrome = check(slow.next);
        } else {
            isPalindrome = check(slow);
        }
        return isPalindrome;
    }

    private static boolean check(ListNode node) {
        if(node == null)
            return true;
        boolean isPalindrome = check(node.next) && node.val == globalHead.val;
        globalHead = globalHead.next;
        return isPalindrome;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        int[] input = {1, 0, 1};
        System.out.println(palindromeLinkedList.isPalindrome(listFromArray(input)));
    }
}
