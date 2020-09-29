public class MinHeapImplementation {

    int capacity;
    int[] arr;
    int currentSize;

    public MinHeapImplementation(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        currentSize = 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void insert(int val) {
        if (!isFull()) {
            int i = currentSize++;
            arr[i] = val;
            while(i > 0 && arr[parent(i)] > arr[i]){
                swap(arr, i, parent(i));
                i = parent(i);
            }
        } else throw new RuntimeException("Heap is full!");
    }

    public int extractMin() {
        if (isEmpty())
            throw new RuntimeException("Heap is Empty!");
        int min = arr[0];
        swap(arr, 0, --currentSize);
        heapify(0);
        return min;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Heap is Empty");
        return arr[0];
    }

    public void heapify(int index) {
        if(index >= 0 && index <= currentSize/2 - 1) {
            int left = left(index);
            int right = right(index);
            int smallest = index;
            if(left < currentSize && arr[left] < arr[smallest])
                smallest = left;
            if (right < currentSize && arr[right] < arr[smallest])
                smallest = right;
            if (smallest != index) {
                swap(arr, index, smallest);
                heapify(smallest);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        assert i >= 0 && i <= arr.length - 1 && j >= 0 && j <= arr.length - 1;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i] + " " + (i == currentSize - 1 ? "| " : ""));
        }
        return stringBuilder.toString();
    }
}
