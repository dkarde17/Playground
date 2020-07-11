import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/maxspprod/
 *
 * You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>
 *
 * LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j.
 *
 * RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.
 *
 * Write a program to find the maximum special product of any integer in the array.
 *
 * Input: You will receive array of integers as argument to function.
 *
 * Return: Maximum special product of any integer in the array modulo 1000000007.
 *
 * Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.
 *
 * Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
 */
public class MAXSPPROD {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        final int mod = 1000000007;
        ArrayList<Integer> leftMax = new ArrayList<>();
        leftMax.add(0);
        int lMax = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            if(lMax <= A.get(i)) {
                leftMax.add(0);
                lMax = A.get(i);
            } else {
                int k = 1;
                int index = i - k;
                while(index >= 0) {
                    if(A.get(index) > A.get(i)) {
                        leftMax.add(index);
                        break;
                    }
                    k++;
                    index = i - k;
                }
            }
        }
        long res = 0;
        int n = A.size() - 1;
        int rMax = A.get(n);
        for(int i = n-1; i >= 0; i--) {
            int r = 0;
            if(rMax <= A.get(i)) {
                rMax = A.get(i);
            } else {
                int k = 1;
                int index = i + k;
                while(index <= n) {
                    if(A.get(index) > A.get(i)) {
                        r = index;
                        break;
                    }
                    k++;
                    index = i + k;
                }
            }
            res = Math.max(res, ((leftMax.get(i)) * 1L * (r)));
        }
        return (int) (res%mod);
    }

    public static void main(String[] args) {
        MAXSPPROD maxspprod = new MAXSPPROD();
        int[] a = {5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9};

        System.out.println(maxspprod.maxSpecialProduct(toList(a)));
    }

    private static ArrayList<Integer> toList(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            list.add(a[i]);
        return list;
    }
}
