package matrix.min_max_row_sum_matrix_partition;

import common.PrintHelper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int[] minMaxRowSumMatrixPartition(int[] numbers) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("numbers=" + PrintHelper.arrayToStringWithIndex(numbers));
        }

        List<Integer> divisibleList = IntStream
                .range(2, numbers.length)
                .boxed()
                .filter(i -> numbers.length % i == 0)
                .collect(Collectors.toList());

        if (PrintHelper.debug) {
            System.out.println("divisibleList=" + divisibleList);
        }

        int min = Integer.MAX_VALUE;
        int row = 0;
        int col = 0;
        for (int numberOfRows : divisibleList) {
            int numberOfColumns = numbers.length / numberOfRows;

            int max = Integer.MIN_VALUE;
            for (int currentMatrixRow = 0; currentMatrixRow < numberOfRows; currentMatrixRow++) {
                int currentMatrixRowPointA = currentMatrixRow * numberOfColumns;
                int currentMatrixRowPointB = (currentMatrixRow + 1) * numberOfColumns;
                int currentRowSummation = sumOfArrayItemsFromPointAToPointB(numbers, currentMatrixRowPointA, currentMatrixRowPointB);
                max = Math.max(max, currentRowSummation);
            }

            if (max < min) {
                min = max;
                row = numberOfRows;
                col = numberOfColumns;
            }
        }

        return new int[]{row, col};
    }

    private int sumOfArrayItemsFromPointAToPointB(int[] arr, int from, int to) {
        return IntStream
                .range(from, to)
                .boxed()
                .mapToInt(i -> arr[i])
                .sum();
    }

}
