package algo;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 345, 43, 3, 4, 4, 6, 65, 34, 56, 567};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        mergeSort(arr, low, high);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int nL = mid - low + 1; //size of left array
        int nR = high - mid; //size of right array
        int[] leftArr = new int[nL];
        int[] rightArr = new int[nR];

        System.arraycopy(arr, low, leftArr, 0, nL);
        System.arraycopy(arr, mid + 1, rightArr, 0, nR);

        int p1 = 0, p2 = 0, k = low;

        while (p1 < nL && p2 < nR) {
            if (leftArr[p1] <= rightArr[p2])
                arr[k++] = leftArr[p1++];
            else if (rightArr[p2] < leftArr[p1])
                arr[k++] = rightArr[p2++];
        }

        while (p1 < nL)
            arr[k++] = leftArr[p1++];
        while (p2 < nR)
            arr[k++] = rightArr[p2++];
    }
}
