import java.util.LinkedList;
import java.util.Queue;

/**
 * CTCI 4.1 Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class Four1RouteBetweenNodes {
    public boolean pathExists(int[][] graph, int source, int target){
        if(graph == null || graph.length == 0)
            return false;
        boolean[] visited = new boolean[graph.length];
        //search using dfs
        boolean dfsAns = dfs(graph, visited, source, target);
//        boolean dfsAns = bfs(graph, source, target);
        return dfsAns;
    }



    private boolean bfs(int[][] graph, int source, int target) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            Integer curr = queue.poll();
            if (!visited[curr]) {
                visited[curr] = true;
                if (curr == target) {
                    found = true;
                    break;
                } else {
                    for(int i : graph[curr])
                        queue.add(i);
                }
            }
        }
        return found;
    }

    private boolean dfs(int[][] graph, boolean[] visited, int curr, int target) {
        boolean found = false;
        if (!visited[curr]) {
            visited[curr] = true;
            if (curr == target)
                found = true;
            for(int i = 0; i < graph[curr].length && !found; i++)
                found = dfs(graph, visited, graph[curr][i], target);
        }
        return found;
    }

    public static void main(String[] args) {
        Four1RouteBetweenNodes four1RouteBetweenNodes = new Four1RouteBetweenNodes();
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(four1RouteBetweenNodes.pathExists(graph, 1, 4));
        System.out.println(four1RouteBetweenNodes.pathExists(graph, 0, 4));
        System.out.println(four1RouteBetweenNodes.pathExists(graph, 1, 2));
        System.out.println(four1RouteBetweenNodes.pathExists(graph, 2, 1));
    }
}
