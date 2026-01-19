package matrix.lucy_spiral_hop;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int lucySpiralHop(int[][] matrix) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] seen = new boolean[n][m];

        int dir = 0;
        int[] rowsDir = new int[]{1, 0, -1, 0};
        int[] colsDir = new int[]{0, 1, 0, -1};
        int[] currentPoint = new int[]{0, 0};
        int[] nextPoint = new int[2];
        List<Integer> lucySpiralHopPath = new ArrayList<>();
        boolean updateLucySpiralHopPath = true;

        for (int i = 0; i < n * m; i++) {

            seen[currentPoint[0]][currentPoint[1]] = true;

            if (updateLucySpiralHopPath) {
                lucySpiralHopPath.add(matrix[currentPoint[0]][currentPoint[1]]);
            }
            updateLucySpiralHopPath = !updateLucySpiralHopPath;

            nextPoint[0] = currentPoint[0] + rowsDir[dir];
            nextPoint[1] = currentPoint[1] + colsDir[dir];

            if (
                    nextPoint[0] < 0 || nextPoint[0] > n - 1
                            || nextPoint[1] < 0 || nextPoint[1] > m - 1
                            || seen[nextPoint[0]][nextPoint[1]]
            ) {
                dir = (dir + 1) % 4;
                nextPoint[0] = currentPoint[0] + rowsDir[dir];
                nextPoint[1] = currentPoint[1] + colsDir[dir];
            }

            currentPoint[0] = nextPoint[0];
            currentPoint[1] = nextPoint[1];
        }

        return lucySpiralHopPath.getLast();
    }

}
