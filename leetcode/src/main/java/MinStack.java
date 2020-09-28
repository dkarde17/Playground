/**
 * https://leetcode.com/problems/min-stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 *
 */
public class MinStack {
    /** initialize your data structure here. */
    Node top;
    public MinStack() {
        top = null;
    }

    public void push(int x) {
        Node node = new Node(x, Math.min(x, (top != null ? top.min : Integer.MAX_VALUE)));
        node.next = top;
        top = node;
    }

    public void pop() {
        Node temp = top;
        top = top.next;
        temp.next = null;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }

    private class Node{
        int val;
        int min;
        Node next;

        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
}
