import java.util.ArrayList;
import java.util.List;

/**
 * (This problem is an interactive problem.)
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= mat.length, mat[i].length <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 */
public class LeftmostColumnWithAtLeastAOne {

    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrix();
        LeftmostColumnWithAtLeastAOne leftmostColumnWithAtLeastAOne = new LeftmostColumnWithAtLeastAOne();
        System.out.println(leftmostColumnWithAtLeastAOne.leftMostColumnWithOne(binaryMatrix));
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        if (dimensions == null)
            return -1;
        int n = dimensions.get(0);
        int m = dimensions.get(1);
        if (n == 0 || m == 0)
            return -1;
        int leftMost = -1;
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;
            while (high >= low) {
                int mid = low + (high - low) / 2;
                int found = binaryMatrix.get(i, mid);
                if (mid == 0) {
                    if (found == 1)
                        return 0; //nothing can be left to zero
                    else low = mid + 1;
                } else {
                    if (found == 1) {
                        int leftToFound = binaryMatrix.get(i, mid - 1);
                        if (leftToFound == 0) {
                            leftMost = leftMost == -1 ? mid : Math.min(leftMost, mid);
                            break;
                        } else {
                            high = mid - 1;
                        }
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return leftMost;
    }

    static class BinaryMatrix {
        int[][] binaryMatrix = {{0, 0}, {0, 1}};

        public int get(int x, int y) {
            return binaryMatrix[x][y];
        }

        public List<Integer> dimensions(){
            List<Integer> dimensions = new ArrayList<>(2);
            dimensions.add(binaryMatrix.length);
            dimensions.add(binaryMatrix[0].length);
            return dimensions;
        }
    }
}
