import java.util.NoSuchElementException;

/**
 * Queue implementation using linked list
 */
public class QueueImplementation<T> {
    ListNode<T> first;
    ListNode<T> last;

    public void add(T val) {
        ListNode<T> node = new ListNode<>(val);
        if(last != null)
            last.next = node;
        last = node;
        if(first == null)
            first = last;
    }

    public T remove() {
        if (first == null)
            throw new NoSuchElementException("Queue Empty");
        ListNode<T> temp = first;
        first = first.next;
        if (first == null)
            last = null;
        temp.next = null;
        return temp.getVal();
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException("Queue Empty");
        return first.getVal();
    }

    public boolean isEmpty() {
        return first == null;
    }
}
