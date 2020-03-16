public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            count[i] = 0;
            int j = 0;
            while(j < nums.length) {
                if(j != i) {
                    if(nums[j] < nums[i])
                        count[i]++;
                }
                j++;
            }
        }
        return count;
    }
}
