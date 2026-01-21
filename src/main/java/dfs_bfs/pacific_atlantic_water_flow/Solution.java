package dfs_bfs.pacific_atlantic_water_flow;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        List<List<Integer>> bothDropRainList = new ArrayList();
        dfsEachNode(heights, bothDropRainList);

        return bothDropRainList;
    }

    private record Node(int row, int col) {

    }

    private enum Side {
        PACIFIC, ATLANTIC
    }

    private void dfsEachNode(int[][] heights, List<List<Integer>> bothDropRainList) {
        int rows = heights.length;
        int cols = heights[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Node node = new Node(i, j);
                boolean[][] visited = new boolean[rows][cols];
                boolean pacific = dfs(heights, node, visited, Side.PACIFIC);
                boolean atlantic = dfs(heights, node, visited, Side.ATLANTIC);
                if (pacific && atlantic) {
                    bothDropRainList.add(List.of(i, j));
                }
            }
        }
    }

    private boolean dfs(int[][] heights, Node node, boolean[][] visited, Side side) {
        visited[node.row][node.col] = true;
        int rows = heights.length;
        int cols = heights[0].length;

        if (side.equals(Side.PACIFIC)) {
            if (node.col == 0 || node.row == 0) {
                return true;
            }
        } else if (side.equals(Side.ATLANTIC)) {
            if (node.col == cols - 1 || node.row == rows - 1) {
                return true;
            }
        }

        List<Node> neighbors = getNeighborsOfNode(heights, node);
        for (Node neighbor : neighbors) {
            if (!visited[neighbor.row][neighbor.col]) {
                return dfs(heights, neighbor, visited, side);
            }
        }

        return false;
    }

    private List<Node> getNeighborsOfNode(int[][] heights, Node node) {
        List<Node> neighbors = new ArrayList<>();
        int[] rowsDir = new int[]{0, 1, 0, -1};
        int[] colsDir = new int[]{-1, 0, 1, 0};
        for (int i = 0; i < rowsDir.length; i++) {
            int row = node.row + rowsDir[i];
            int col = node.col + colsDir[i];
            if (row >= 0 && row < heights.length
                    && col >= 0 && col < heights[row].length
                    && heights[row][col] <= heights[node.row][node.col]
            ) {
                Node n = new Node(row, col);
                neighbors.add(n);
            }
        }
        return neighbors;
    }

}
