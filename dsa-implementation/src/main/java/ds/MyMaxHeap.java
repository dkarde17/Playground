package ds;

public class MyMaxHeap {

    private final int capacity;
    private final int[] data;
    private int currentSize;

    public MyMaxHeap(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        for (int i = 0; i < capacity; i++)
            data[i] = Integer.MIN_VALUE;
        this.currentSize = 0;
    }

    public void insert(int value) {
        if(!isFull()) {
            int index = currentSize++;
            data[index] = value;
            heapifyUp(index);
        } else throw new RuntimeException("Heap is full!");
    }

    private void heapifyUp(int index) {
        int parent = parent(index);
        if (index > 0 && data[parent] < data[index]) {
            swap(data, index, parent);
            heapifyUp(parent);
        }
    }

    private void swap(int[] data, int index, int parent) {
        int temp = data[index];
        data[index] = data[parent];
        data[parent] = temp;
    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    //return max
    public int poll() {
        if (currentSize > 0) {
            int result = data[0];
            data[0] = data[--currentSize];
            heapifyDown(0);
            return result;
        } else throw new IllegalStateException("Heap is empty!");
    }

    private void heapifyDown(int index) {
        if(index >= 0 && index <= (currentSize-1)/2) {
            int leftChild = leftChildIndex(index);
            int rightChild = rightChielIndex(index);
            int largest = index;
            if (leftChild < currentSize && data[leftChild] > data[index])
                largest = leftChild;
            if (rightChild < currentSize && data[rightChild] > data[largest])
                largest = rightChild;
            if (largest != index) {
                swap(data, index, largest);
                heapifyDown(largest);
            }
        }
    }

    private int leftChildIndex(int index) {
        return 2*index + 1;
    }

    private int rightChielIndex(int index) {
        return 2*index + 2;
    }

    public int peek() {
        if (currentSize > 0)
            return data[0];
        else throw new IllegalStateException("Heap is empty!");
    }

    private boolean isFull() {
        return currentSize == capacity;
    }
}
