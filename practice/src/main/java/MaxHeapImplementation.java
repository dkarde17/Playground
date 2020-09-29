public class MaxHeapImplementation {

    int[] arr;
    int currentSize;
    int capacity;

    public MaxHeapImplementation(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        for (int i = 0; i < capacity; i++)
            arr[i] = Integer.MIN_VALUE;
        currentSize = 0;
    }

    public void insert(int val) {
        System.out.println("insert " + val);
        if(!isFull()) {
            int i = currentSize++;
            arr[i] = val;
            while(i > 0 && arr[parent(i)] < arr[i]) {
                swap(arr, i, parent(i));
                i = parent(i);
            }
        } else System.out.println("Heap is full!");
    }

    private void swap(int[] arr, int i, int j) {
        if(i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    private boolean isFull() {
        return currentSize == capacity;
    }

    public int peek(){
        System.out.println("peek");
        if (!isEmpty()) {
            return arr[0];
        } else System.out.println("Heap is empty!");
        return Integer.MIN_VALUE;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public int extractMax(){
        System.out.println("extract max");
        if (!isEmpty()) {
            int res = arr[0];
            swap(arr, 0, --currentSize);
            maxHeapify(0);
            return res;
        } else System.out.println("Heap is empty!");
        return Integer.MIN_VALUE;
    }

    private void maxHeapify(int index) {
        if(index >= 0 && index <= currentSize/2 - 1) {
            int largest = index;
            int left = left(index);
            int right = right(index);
            if(left < currentSize && arr[left] > arr[largest])
                largest = left;
            if (right < currentSize && arr[right] > arr[largest])
                largest = right;
            if (index != largest) {
                swap(arr, index, largest);
                maxHeapify(largest);
            }
        }
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i] + " " + (i == currentSize - 1 ? "| " : ""));
        }
        String string = stringBuilder.toString();
        System.out.println(string);
        return string;
    }
}
