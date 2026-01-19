package matrix.search_matrix;

import common.PrintHelper;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("target=" + target + " matrix=");
            System.out.println(PrintHelper.matrixToString(matrix));
        }

        int n = matrix.length;
        int m = matrix.length > 0 ? matrix[0].length : 0;

        int left = 0;
        int right = (n * m) - 1;
        boolean hasTarget = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (getMatrixValueMappedAsArray(matrix, mid) == target) {
                hasTarget = true;
                break;
            } else if (getMatrixValueMappedAsArray(matrix, mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return hasTarget;
    }

    private int getMatrixValueMappedAsArray(int[][] matrix, int index) {
        int row = index / matrix[0].length;
        int col = index % matrix[0].length;
        return matrix[row][col];
    }

}
