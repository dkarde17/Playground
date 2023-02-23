import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The
 * implemented queue should support all the functions of a normal queue
 * (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to
 * top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You
 * may simulate a stack using a list or deque (double-ended queue) as long as
 * you use only a stack's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 *
 *
 * Follow-up: Can you implement the queue such that each operation is
 * amortized O(1) time complexity? In other words, performing n operations
 * will take overall O(n) time even if one of those operations may take longer.
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int next;
    int size;
    boolean isQueue = false;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(isQueue) {
            swap(stack1, stack2);
            isQueue = false;
        }
        if(size == 0)
            next = x;
        if(stack1.isEmpty())
            stack2.push(x);
        else stack1.push(x);
        size++;
    }

    private <E> void swap(Stack<E> s1, Stack<E> s2) {
        if(s1.isEmpty()) {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        } else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public int pop() {
        if(!isQueue) {
            swap(stack1, stack2);
            isQueue = true;
        }
        int res = 0;
        if(stack1.isEmpty()){
            res = stack2.pop();
            if(!stack2.isEmpty())
                next = stack2.peek();
        }
        else {
            res = stack1.pop();
            if(!stack1.isEmpty())
                next = stack1.peek();
        }
        size--;
        return res;
    }

    public int peek() {
        return next;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
