import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/majority-element/
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example :
 *
 * Input : [2, 1, 2]
 * Return  : 2 which occurs 2 times which is greater than 3/2.
 */
public class MajorityElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        int count = 0;
        Integer candidate = null;
        for(int i = 0; i < A.size() && count <= A.size()/2; i++) {
            if(count == 0)
                candidate = A.get(i);
            count += A.get(i).equals(candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] arr = {668474};
        int[] arr2 = {5, 3, 4, 5, 5, 5, 2};
        List<Integer> list = new ArrayList<>();
        for (int i : arr)
            list.add(i);
        System.out.println(majorityElement.majorityElement(list));
    }
}
