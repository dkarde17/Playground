import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <p>
 * Implement the FirstUnique class:
 * <p>
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 */
public class FirstUniqueNumber {
    Node head;
    Node tail;
    Map<Integer, Node> tracker = new HashMap();
    Set<Integer> removed = new HashSet<>();

    public FirstUniqueNumber(int[] nums) {
        if (nums != null)
            for (int i = 0; i < nums.length; i++) {
                int value = nums[i];
                if (!tracker.containsKey(value)) {
                    Node node = new Node(value);
                    addNode(node);
                } else removeNode(tracker.get(value));
            }
    }

    private void addNode(Node node) {
        tracker.put(node.value, node);
        if (head == null)
            head = node;
        if (tail == null)
            tail = node;
        else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }
    }

    public int showFirstUnique() {
        return head != null ? head.value : -1;
    }

    public void add(int value) {
        if (!tracker.containsKey(value)) {
            addNode(new Node(value));
        } else {
            removeNode(tracker.get(value));
        }
    }

    private void removeNode(Node node) {
        if (removed.contains(node.value))
            return;
        if (node != head) {
            node.left.right = node.right;
        } else {
            head = node.right;
            if (head != null)
                head.left = null;
        }
        if (node != tail)
            node.right.left = node.left;
        else {
            tail = node.left;
            if (tail != null)
                tail.right = null;
        }
        removed.add(node.value);
    }

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        String testString = new BufferedReader(new InputStreamReader(Objects.requireNonNull(FirstUniqueNumber.class.getClassLoader()
                .getResourceAsStream("FirstUniqueNumber.testcase")))).readLine();
        int[] testData = Arrays.stream(testString.split(",")).map(String::trim).map(Integer::parseInt)
                .mapToInt(Integer::intValue).toArray();
        int[] seedData = {7, 7, 7, 7, 7, 7};
        FirstUniqueNumber firstUniqueNumber = new FirstUniqueNumber(testData);
        firstUniqueNumber.add(28);
        firstUniqueNumber.add(346);
        firstUniqueNumber.add(268);
        firstUniqueNumber.add(9);
        System.out.println(firstUniqueNumber.showFirstUnique());
    }
}
