import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 02 = 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> alreadyPreasent = new HashSet<>();
        do {
            alreadyPreasent.add(n);
            sum = 0;
            while (n != 0) {
                int i = n%10;
                sum = sum + i * i;
                n = n/10;
            }
            n = sum;
        }  while(sum != 1 && !alreadyPreasent.contains(sum));
        return sum == 1;
    }

    public static void main(String[] args) {
        int x = 25;
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(x));
    }

    /**
     * circular linked list solution!
     * slow pointer and fast pointer
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = HappySq(slow);
            fast = HappySq(HappySq(fast));
        } while (slow!=fast);
        return slow == 1? true: false;
    }

    private int HappySq(int n) {
        int num = 0;
        while(n != 0) {
            num = num + (n%10) * (n%10);
            n= n/10;
        }
        return num;
    }
}
