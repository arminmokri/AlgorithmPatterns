package matrix.rotate_image;

import common.PrintHelper;

public class Solution {

    public void rotate(int[][] matrix) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("numbers=");
            System.out.println(PrintHelper.matrixToString(matrix));
        }

        // swap up and down - for all columns
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                swap(matrix, i, j, matrix.length - (i + 1), j);
            }
        }

        if (PrintHelper.debug) {
            System.out.println("numbers=");
            System.out.println(PrintHelper.matrixToString(matrix));
        }

        //
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        if (PrintHelper.debug) {
            System.out.println("numbers=");
            System.out.println(PrintHelper.matrixToString(matrix));
        }
    }

    private void swap(int[][] matrix, int rowA, int colA, int rowB, int colB) {
        int temp = matrix[rowA][colA];
        matrix[rowA][colA] = matrix[rowB][colB];
        matrix[rowB][colB] = temp;
    }

}
