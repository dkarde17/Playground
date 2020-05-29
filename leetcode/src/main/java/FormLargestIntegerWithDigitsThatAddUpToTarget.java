import java.util.*;

/**
 * Given an array of integers cost and an integer target. Return the maximum integer you can paint under the following rules:
 *
 * The cost of painting a digit (i+1) is given by cost[i] (0 indexed).
 * The total cost used must be equal to target.
 * Integer does not have digits 0.
 * Since the answer may be too large, return it as string.
 *
 * If there is no way to paint any integer given the condition, return "0".
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [4,3,2,5,6,7,2,5,5], target = 9
 * Output: "7772"
 * Explanation:  The cost to paint the digit '7' is 2, and the digit '2' is 3. Then cost("7772") = 2*3+ 3*1 = 9. You could also paint "997", but "7772" is the largest number.
 * Digit    cost
 *   1  ->   4
 *   2  ->   3
 *   3  ->   2
 *   4  ->   5
 *   5  ->   6
 *   6  ->   7
 *   7  ->   2
 *   8  ->   5
 *   9  ->   5
 * Example 2:
 *
 * Input: cost = [7,6,5,5,5,6,8,7,8], target = 12
 * Output: "85"
 * Explanation: The cost to paint the digit '8' is 7, and the digit '5' is 5. Then cost("85") = 7 + 5 = 12.
 * Example 3:
 *
 * Input: cost = [2,4,6,2,4,6,4,4,4], target = 5
 * Output: "0"
 * Explanation: It's not possible to paint any integer with total cost equal to target.
 * Example 4:
 *
 * Input: cost = [6,10,15,40,40,40,40,40,40], target = 47
 * Output: "32211"
 *
 *
 * Constraints:
 *
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 */
public class FormLargestIntegerWithDigitsThatAddUpToTarget {
    //TODO: complete this solution
    public String largestNumber(int[] cost, int target) {
        Map<Integer, List<Integer>> costToDigit = new HashMap<>();
        Set<Integer> presentCosts = new HashSet<>();
        for (int i = 0; i < cost.length; i++) {
            int digit = i + 1;
            int costI = cost[i];
            presentCosts.add(costI);
            if (costToDigit.containsKey(costI)) {
                costToDigit.get(costI).add(digit);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(digit);
                costToDigit.put(costI, list);
            }
        }
        Arrays.sort(cost);
        int totalCost = 0;
        int dupTarget = target;
        List<Integer> digits = new ArrayList<>();
        int index = 0;
        for (int i : presentCosts) {
            List<Integer> list = costToDigit.get(i);
            int digit = list.get(list.size() - 1);
            while (totalCost < target && dupTarget - i >= i || dupTarget - i == 0) {
                dupTarget -= i;
                if(!digits.isEmpty() && digits.get(index) < digit) {
                    digits.add(digits.get(index));
                    digits.remove(index);
                    digits.add(index++, digit);
                } else digits.add(digit);
                totalCost += i;
            }
        }
        StringBuilder sb = new StringBuilder();
        digits.forEach(sb::append);
        if (totalCost != target || sb.length() == 0)
            return "0";
        else return sb.toString();
    }

    public static void main(String[] args) {
        FormLargestIntegerWithDigitsThatAddUpToTarget thisObj = new FormLargestIntegerWithDigitsThatAddUpToTarget();
        int[] arr = {6,10,15,40,40,40,40,40,40};
        int target = 47;
        System.out.println(thisObj.largestNumber(arr, target));
    }
}
