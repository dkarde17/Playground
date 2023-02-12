package ds;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MyArray {
    private final Map<Integer, String> data;
    private int length;

    public MyArray() {
        this.length = 0;
        this.data = new HashMap<>();
    }

    public void push(String value) {
        data.put(length++, value);
    }

    public String pop() {
        return data.remove(--length);
    }

    public String delete(int index) {
        String deletedValue = data.get(index);
        shiftDataLeft(index);
        data.remove(--length);
        return deletedValue;
    }

    /**
     * shift data to left
     *
     * @param index
     */
    private void shiftDataLeft(int index) {
        for (int i = index; i < length - 1; i++) {
            data.put(i, data.get(i + 1));
        }
    }

    public void insert(int index, String value) {
        shiftDataRight(index);
        data.put(index, value);
    }

    private void shiftDataRight(int index) {
        for (int i = length; i > index; i--)
            data.put(i, data.get(i - 1));
        length++;
    }

    public void print() {
        System.out.println("Length of the Array = " + length);
        this.data.entrySet().stream().sorted(
                Comparator.comparingInt(Map.Entry::getKey)).forEach(
                        integerStringEntry ->
                                System.out.printf("key : %d :: value : %s\n",
                                        integerStringEntry.getKey(), integerStringEntry.getValue()));
    }
}
