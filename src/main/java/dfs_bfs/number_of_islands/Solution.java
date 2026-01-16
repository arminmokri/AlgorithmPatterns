package dfs_bfs.number_of_islands;

import common.PrintHelper;

import java.util.*;


public class Solution {

    public int numIslands(char[][] grid) {
        if (PrintHelper.debug) {
            System.out.println();
        }
        return bfsDisconnected(grid);
    }

    private record Node(char val, int row, int col) {

    }

    private int bfsDisconnected(char[][] graph) {
        Set<Node> visited = new HashSet<>();

        int numIslands = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                Node currentNode = new Node(graph[i][j], i, j);
                if (currentNode.val == '1' && !visited.contains(currentNode)) {
                    bfsFromNode(graph, currentNode, visited);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void bfsFromNode(char[][] graph, Node node, Set<Node> visited) {
        Queue<Node> queue = new LinkedList<>();

        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cureentNode = queue.poll();

            List<Node> neighbors = getNeighborsOfNode(graph, cureentNode);
            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    private List<Node> getNeighborsOfNode(char[][] graph, Node node) {
        List<Node> neighbors = new ArrayList<>();
        int[] rowsDir = new int[]{0, 1, 0, -1};
        int[] colsDir = new int[]{-1, 0, 1, 0};
        for (int i = 0; i < rowsDir.length; i++) {
            int row = node.row + rowsDir[i];
            int col = node.col + colsDir[i];
            if (row >= 0 && row < graph.length
                    && col >= 0 && col < graph[row].length
                    && graph[row][col] == '1'
            ) {
                Node n = new Node(graph[row][col], row, col);
                neighbors.add(n);
            }
        }
        return neighbors;
    }


}
