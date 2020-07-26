import java.util.ArrayList;
import java.util.List;

/**
 *https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
 *
 * Given an array of real numbers greater than zero in form of strings.
 * Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 * Return 1 for true or 0 for false.
 *
 * Example:
 *
 * Given [0.6, 0.7, 0.8, 1.2, 0.4] ,
 *
 * You should return 1
 *
 * as
 *
 * 0.6+0.7+0.4=1.7
 *
 * 1<1.7<2
 *
 * Hence, the output is 1.
 *
 * O(n) solution is expected.
 *
 * Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 */
public class TripletsWithSumBetweenGivenRange {
    public int solve(ArrayList<String> A) {
        if(A == null || A.size() < 3)
            return 0;
        double[] nums = new double[3];
        double sum = 0d;
        int minIndex = 0;
        int maxIndex = 0;
        for(int i = 0; i < 3; i++) {
            nums[i] = Double.parseDouble(A.get(i));
            sum += nums[i];
            if(nums[i] < nums[minIndex] )
                minIndex = i;
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for(int i = 3; i < A.size(); i++) {
            double num = Double.parseDouble(A.get(i));
            if(1 < sum && sum < 2)
                return 1;
            if(sum >= 2 && num < nums[maxIndex]) {
                sum -= nums[maxIndex];
                nums[maxIndex] = num;
                sum += nums[maxIndex];
            } else if (sum <= 1 && num > nums[minIndex]) {
                sum -= nums[minIndex];
                nums[minIndex] = num;
                sum += nums[minIndex];
            }
            for(int j = 0; j < 3; j++) {
                if(nums[j] < nums[minIndex] )
                    minIndex = j;
                if(nums[j] > nums[maxIndex])
                    maxIndex = j;
            }
        }
        if(1 < sum && sum < 2)
            return 1;
        else return 0;
    }

    public static void main(String[] args) {
        TripletsWithSumBetweenGivenRange tripletsWithSumBetweenGivenRange = new TripletsWithSumBetweenGivenRange();
        String[] strings = {"2.673662", "2.419159", "0.573816", "2.454376", "0.403605", "2.503658", "0.806191"};
        ArrayList<String> a = new ArrayList<>();

        for(String s : strings)
            a.add(s);
        System.out.println(tripletsWithSumBetweenGivenRange.solve(a));
    }
}
