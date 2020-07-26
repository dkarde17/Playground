import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 *
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 *
 * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 *
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 *
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * Examples:
 *
 * Input 1:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 1, 1]   ]
 *
 * Output 1:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [1, 0, 1]   ]
 *
 * Input 2:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 0, 1]   ]
 *
 * Output 2:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [0, 0, 0]   ]
 */
public class SetMatrixZeros {
    /*
    Using O(n + m) space complexity.
    It can be done in constant space too.
     */
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if(a == null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0)
            return;
        int n = a.size();
        int m = a.get(0).size();

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a.get(i).get(j) == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        rows.forEach( row -> {
            for(int i = 0; i < m; i++)
                a.get(row).set(i, 0);
        });
        cols.forEach(col -> {
            for(int i = 0; i < n; i++)
                a.get(i).set(col, 0);
        });
    }
}
