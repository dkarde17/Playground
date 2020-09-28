public class ListNode<T> {
    private final T val;
    public ListNode<T> next;

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
}