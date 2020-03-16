public class DecompressRunLengthEncodedList_1313 {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int decompressedSize = 0;
        for (int i = 0; i <= (n-1)/2; i++) {
            decompressedSize += nums[2*i];
        }
        int decompressedList[] = new int[decompressedSize];
        int index = 0;
        for(int i = 0; i < n; i+=2) {
            for(int j = 0; j < nums[i]; j++)
                decompressedList[index++] = nums[i + 1];
        }
        return decompressedList;
    }

    public static void main(String[] args) {
        DecompressRunLengthEncodedList_1313 decompressRunLengthEncodedList_1313 = new DecompressRunLengthEncodedList_1313();
        int[] test = {1, 2, 3, 4};
        System.out.println(decompressRunLengthEncodedList_1313.decompressRLElist(test));
    }
}
