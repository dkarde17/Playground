import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * <p>
 * Given a directed acyclic graph of N nodes. Find all possible paths from node 0 to node N-1, and return them in any order.
 * <p>
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 * <p>
 * <p>
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Example 3:
 * <p>
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * Example 4:
 * <p>
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * Example 5:
 * <p>
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourceToTarget {

    /**
     * Runtime: 2 ms, faster than 97.85% of Java online submissions for All Paths From Source to Target.
     * Memory Usage: 40.7 MB, less than 97.24% of Java online submissions for All Paths From Source to Target.
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int source = 0;
        int n = graph.length;
        int target = n - 1;
        List<List<Integer>> res = new ArrayList();
        boolean[] visited = new boolean[graph.length];
        for (int i : graph[source]) {
            if (i != source && !visited[i]) {
                List<Integer> list = new ArrayList();
                list.add(source);
                dfs(graph, visited, res, list, i, target);
            }
        }
        return res;
    }

    public void dfs(int[][] graph, boolean[] visited, List<List<Integer>> res, List<Integer> list, int curr, int target) {
        list.add(curr);
        visited[curr] = true;
        List<Integer> original = new ArrayList<>(list);
        if (curr == target) {
            res.add(list);
            visited[curr] = false;
            return;
        } else {
            for (int i : graph[curr]) {
                if (i != curr && !visited[i]) {
                    List<Integer> temp = new ArrayList<>(original);
                    dfs(graph, visited, res, temp, i, target);
                }
            }
            visited[curr] = false;
        }
    }

    public static void main(String[] args) {
        int[][] input = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        AllPathsFromSourceToTarget allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
        List<List<Integer>> ans = allPathsFromSourceToTarget.allPathsSourceTarget(input);
        System.out.println("debug");
    }
}
