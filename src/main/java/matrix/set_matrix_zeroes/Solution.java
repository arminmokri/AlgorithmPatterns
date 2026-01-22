package matrix.set_matrix_zeroes;

import common.PrintHelper;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("matrix=");
            System.out.println(PrintHelper.matrixToString(matrix));
        }

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(Integer.valueOf(i));
                    cols.add(Integer.valueOf(j));
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(Integer.valueOf(i)) || cols.contains(Integer.valueOf(j))) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (PrintHelper.debug) {
            System.out.println("matrix=");
            System.out.println(PrintHelper.matrixToString(matrix));
        }

    }
}
