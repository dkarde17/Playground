/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 */
public class SetMatrixZeroes {

    /**
     * Runtime: 1 ms, faster than 97.43% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 40.8 MB, less than 82.66% of Java online submissions for Set Matrix Zeroes.
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean rowZero = false; //to keep track of whether there is a zero in the first row
        boolean colZero = false; //to keep track of whether there is a zero in the first col

        //set the first elements 0 if any zero is found
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0)
                        rowZero = true;
                    if(j == 0)
                        colZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //if first element is zero then set the entire row as zero
        for(int i = 1; i < n; i++)
            if(matrix[i][0] == 0)
                for(int j = 1; j < m; j++)
                    matrix[i][j] = 0;

        //if first element is zero then set the entire col as zero
        for(int j = 1; j < m; j++)
            if(matrix[0][j] == 0)
                for(int i = 1; i < n; i++)
                    matrix[i][j] = 0;
        //if first col had a zero then only set the whole first col as zero
        if(colZero)
            for(int i = 0; i < n; i++)
                matrix[i][0] = 0;

        //if first row had a zero then only set the whole first row as zero
        if(rowZero)
            for(int j = 0; j < m; j++)
                matrix[0][j] = 0;
    }
}
