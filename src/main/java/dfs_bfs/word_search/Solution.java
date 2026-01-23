package dfs_bfs.word_search;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public boolean exist(char[][] board, String word) {
        if (PrintHelper.debug) {
            System.out.println();
        }
        if (PrintHelper.debug) {
            System.out.println("word=" + word + " board=");
            System.out.println(PrintHelper.matrixToString(board));
        }

        return dfsEachNode(board, word);
    }

    private record Node(int row, int col) {
        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    private boolean dfsEachNode(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean flagFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Node node = new Node(i, j);
                boolean[][] visited = new boolean[rows][cols];
                flagFound = dfs(board, node, visited, word, 0);
                if (flagFound) {
                    break;
                }
            }
            if (flagFound) {
                break;
            }
        }
        return flagFound;
    }

    private boolean dfs(char[][] board, Node node, boolean[][] visited, String word, int index) {
        if (index < word.length() && board[node.row][node.col] != word.charAt(index)) {
            return false;
        } else if (index >= word.length() - 1) {
            return true;
        }

        visited[node.row][node.col] = true;

        boolean flagFound = false;
        List<Node> neighbors = getNeighborsOfNode(board, node);
        for (Node neighbor : neighbors) {
            if (!visited[neighbor.row][neighbor.col]) {
                flagFound = dfs(board, neighbor, visited, word, index + 1);
                if (flagFound) {
                    break;
                }
            }
        }

        // (backtrack)
        visited[node.row][node.col] = false;

        return flagFound;
    }

    private List<Node> getNeighborsOfNode(char[][] board, Node node) {
        List<Node> neighbors = new ArrayList<>();
        int[] rowsDir = new int[]{0, 1, 0, -1};
        int[] colsDir = new int[]{-1, 0, 1, 0};
        for (int i = 0; i < rowsDir.length; i++) {
            int row = node.row + rowsDir[i];
            int col = node.col + colsDir[i];
            if (row >= 0 && row < board.length
                    && col >= 0 && col < board[row].length
            ) {
                Node n = new Node(row, col);
                neighbors.add(n);
            }
        }
        return neighbors;
    }

}
