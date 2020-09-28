import util.ArrayUtils;
import util.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode beforeHead = before;
        ListNode after = new ListNode(0);
        ListNode afterHead = after;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        afterHead = afterHead.next;
        after.next = null;
        before.next = afterHead;
        beforeHead = beforeHead.next;
        return beforeHead;
    }

    public static void main(String[] args) {
        int[] input = {1, 1};
        ListNode head = ArrayUtils.listFromArray(input);
        PartitionList partitionList = new PartitionList();
        ListNode partition = partitionList.partition(head, 2);
        System.out.println("debug");
    }
}
