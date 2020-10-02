import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * similar to CTCI 4.7
 *
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class CourseScheduleII {
    /**
     * Runtime: 5 ms, faster than 73.70% of Java online submissions for Course Schedule II.
     * Memory Usage: 41.7 MB, less than 24.54% of Java online submissions for Course Schedule II.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new ArrayList[numCourses];
        for(int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new ArrayList();
        for(int i = 0; i < prerequisites.length; i++) {
            adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Stack<Integer> courseOrder = new Stack<>();
        AtomicBoolean cycleFound = new AtomicBoolean(false);
        boolean[] visited = new boolean[numCourses];
        boolean[] hasCycle = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            dfs(i, adjacencyList, courseOrder, cycleFound, visited, hasCycle);
        }
        int[] order = new int[0];
        int i = 0;
        if(!cycleFound.get()){
            order = new int[numCourses];
            while(!courseOrder.isEmpty())
                order[i++] = courseOrder.pop();
        }

        return order;
    }

    public void dfs(int curr, List<Integer>[] adjacencyList, Stack<Integer> courseOrder, AtomicBoolean cycleFound, boolean[] visited, boolean[] hasCycle) {
        if(hasCycle[curr])
            cycleFound.set(true);
        else if(!visited[curr] && !cycleFound.get()) {
            visited[curr] = true;
            hasCycle[curr] = true;
            adjacencyList[curr].forEach(x -> dfs(x, adjacencyList, courseOrder, cycleFound, visited, hasCycle));
            courseOrder.push(curr);
            hasCycle[curr] = false;
        }
    }

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[][] prerequisites = {{0, 1},{1, 0}};
        int[] order = courseScheduleII.findOrder(2, prerequisites);
        System.out.println("debug");
    }

}
