import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        if(A != null && A.length != 0 && B != null && B.length != 0) {
            int aIt = 0, bIt = 0;
            int i = 0;
            while(aIt < A.length && bIt < B.length) {
                int beginEarly = Math.min(A[aIt][0], B[bIt][0]);
                int beginLate = Math.max(A[aIt][0], B[bIt][0]);
                int endEarly = Math.min(A[aIt][1], B[bIt][1]);
                int endLate = Math.max(A[aIt][1], B[bIt][1]);
                if(endEarly >= beginLate) {
                    int[] interval = new int[2];
                    interval[0] = beginLate;
                    interval[1] = endEarly;
                    list.add(interval);
                }
                if(endLate == A[aIt][1] && endLate == B[bIt][1]) {
                    ++aIt;
                    ++bIt;
                } else if (endLate == A[aIt][1])
                    ++bIt;
                else ++aIt;
            }
        }
        return list.stream().toArray(int[][]::new);
    }

    //1ms submission, the one above is 5ms
    /*
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> result = new ArrayList<>();

        getIntervals(result, A, B, 0, 0);

        return result.toArray(new int[result.size()][2]);

    }

    public void getIntervals(List<int[]> result, int[][] A, int[][] B, int Ap, int Bp){

        if(Ap >= A.length || Bp >= B.length) return;

        int start = A[Ap][0] < B[Bp][0] ? B[Bp][0] : A[Ap][0];

        int end = A[Ap][1] > B[Bp][1] ? B[Bp][1] : A[Ap][1];

        if(end >= start) result.add(new int[]{start, end});

        //System.out.println(start + "end" + end);

        if(A[Ap][1] <= B[Bp][1]){
            getIntervals(result, A, B, Ap + 1, Bp);
        } else {
            getIntervals(result, A, B, Ap, Bp + 1);
        }

    }
     */
}
