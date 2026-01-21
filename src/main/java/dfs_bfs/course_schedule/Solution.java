package dfs_bfs.course_schedule;

import common.PrintHelper;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("numCourses=" + numCourses + " prerequisites=");
            System.out.println(PrintHelper.matrixToString(prerequisites));
        }

        boolean canFinish = !dfsDisconnectedIsCyclic(prerequisites, numCourses);

        if (PrintHelper.debug) {
            System.out.println("canFinish=" + canFinish);
        }

        return canFinish;
    }

    private boolean dfsDisconnectedIsCyclic(int[][] graph, int numCourses) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfsIsCyclic(graph, i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsIsCyclic(int[][] graph, int node, boolean[] visited, boolean[] recStack) {

        // Node already in recursion stack cycle found
        if (recStack[node]) {
            return true;
        }

        // Already processed no need to visit again
        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        recStack[node] = true;

        // Recur for all adjacent nodes
        for (int[] neighborItem : graph) {
            if (neighborItem[0] == node) {
                if (dfsIsCyclic(graph, neighborItem[1], visited, recStack))
                    return true;
            }
        }

        // Remove from recursion stack before backtracking
        recStack[node] = false;
        return false;
    }
}
