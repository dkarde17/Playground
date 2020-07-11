import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://www.interviewbit.com/problems/largest-number/
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example:
 *
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumber {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        if(A == null || A.size() == 0)
            return "";
        else if(A.size() == 1)
            return String.valueOf(A.get(0));
        final boolean[] allZero = {true};
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 != 0 || o2 != 0)
                    allZero[0] = false;
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                long l1 = Long.parseLong(s1);
                long l2 = Long.parseLong(s2);
                return -Long.compare(l1, l2);
            }
        });
        StringBuilder sb = new StringBuilder();
        A.forEach(x -> sb.append(x));
        return allZero[0] ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] a = {0, 0, 0};
        System.out.println(largestNumber.largestNumber(toList(a)));
    }

    private static ArrayList<Integer> toList(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            list.add(a[i]);
        return list;
    }
}

