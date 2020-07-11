import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/rotting-oranges/
 * <p>
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * <p>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class RottenOranges {
    int[] rowOffset = {0, -1, 1, 0};
    int[] colOffset = {-1, 0, 0, 1};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int totalGood = 0;
        List<Location> queue = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 3) {
                    ++totalGood;
                } else if (grid[i][j] == 2) {
                    addNeighboursToQueue(queue, i, j, rows, cols, grid);
                }
            }
        }
        queue.add(new Location(-1, -1));
        if(totalGood == 0)
            return 0;
        int res = 0;
        //bfs
        int index = 0;
        while (index < queue.size()) {
            Location curr = queue.get(index);
            if (curr.row != -1) {
                --totalGood;
                addNeighboursToQueue(queue, curr.row, curr.col, rows, cols, grid);
            } else {
                ++res;
                if (queue.get(queue.size() - 1).row != -1)
                    queue.add(new Location(-1, -1));
            }
            ++index;
        }
        if (totalGood != 0)
            return -1;
        else return res;
    }

    private void addNeighboursToQueue(List<Location> queue, int i, int j, int rows, int cols, int[][] grid) {
        for (int k = 0; k < 4; k++) {
            int r = i + rowOffset[k];
            int c = j + colOffset[k];
            if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                queue.add(new Location(r, c));
                grid[r][c] = 3;
            }
        }
    }

    private class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid = {{0, 2}};
        System.out.println(rottenOranges.orangesRotting(grid));
    }
}
