package algo;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 111, 32, 563, 4, 25};
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void insertionSort(int[] arr) {
        if (arr == null)
            throw new RuntimeException("Input array is null");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1])
                    swap(arr, j, j-1);
                else break;
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
