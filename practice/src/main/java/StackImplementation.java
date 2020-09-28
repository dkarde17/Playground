import java.util.EmptyStackException;

/**
 * Stack implementation using linkedList
 */
public class StackImplementation<T> {

    ListNode<T> top;

    public void push(T val) {
        ListNode<T> node = new ListNode<>(val);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.getVal();
    }

    public T pop() {
        if (top == null)
            throw new EmptyStackException();
        ListNode<T> node = top;
        top = top.next;
        node.next = null;
        return node.getVal();
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class ListNode<T> {
        private final T val;
        private ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }

        public ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }

        public T getVal() {
            return val;
        }

        public ListNode<T> getNext() {
            return next;
        }
    }
}
