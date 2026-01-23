package dynamic_programming.zero_one_knapsack;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Solution {

    public Result knapsackTabulation(String[] names, int[] values, int[] weights, int capacity) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("names=" + PrintHelper.arrayToStringWithIndex(names));
            System.out.println("values=" + PrintHelper.arrayToStringWithIndex(values));
            System.out.println("weights=" + PrintHelper.arrayToStringWithIndex(weights));
            System.out.println("capacity=" + capacity);
        }

        Result result = bottomUp(names, values, weights, capacity);

        if (PrintHelper.debug) {
            System.out.println("result=" + result);
        }

        return result;
    }

    private Result recursion(String[] names, int[] values, int[] weights, int capacity, int index) {
        if (capacity < 0) {
            return new Result(-1, List.of());
        } else if (capacity == 0) {
            return new Result(0, List.of());
        } else if (index >= names.length) {
            return new Result(0, List.of());
        }

        Result withItem = recursion(names, values, weights, capacity - weights[index], index + 1);
        Result withoutItem = recursion(names, values, weights, capacity, index + 1);

        if (withItem.value >= 0 && withItem.value + values[index] > withoutItem.value) {
            List<String> chosen = Stream.concat(
                            Stream.of(names[index]),
                            withItem.items.stream()
                    )
                    .toList();
            return new Result(withItem.value + values[index], chosen);
        } else {
            return withoutItem;
        }
    }

    private Result memoization(String[] names, int[] values, int[] weights, int capacity, int index, Result[][] memo) {
        if (capacity < 0) {
            return new Result(-1, List.of());
        } else if (capacity == 0) {
            return new Result(0, List.of());
        } else if (index >= names.length) {
            return new Result(0, List.of());
        } else if (Objects.nonNull(memo[capacity][index])) {
            return memo[capacity][index];
        }

        Result withItem = memoization(names, values, weights, capacity - weights[index], index + 1, memo);
        Result withoutItem = memoization(names, values, weights, capacity, index + 1, memo);

        if (withItem.value >= 0 && withItem.value + values[index] > withoutItem.value) {
            List<String> chosen = Stream.concat(
                            Stream.of(names[index]),
                            withItem.items.stream()
                    )
                    .toList();
            memo[capacity][index] = new Result(withItem.value + values[index], chosen);
        } else {
            memo[capacity][index] = withoutItem;
        }

        return memo[capacity][index];
    }

    private Result bottomUp(String[] names, int[] values, int[] weights, int capacity) {

        int numberOfItems = values.length;

        // matrix[i][j] = max value using first i items with capacity j
        int[][] matrix = new int[numberOfItems + 1][capacity + 1];

        // Fill DP table
        for (int i = 1; i <= numberOfItems; i++) {
            int itemValue = values[i - 1];
            int itemWeight = weights[i - 1];

            for (int j = 1; j <= capacity; j++) {
                if (itemWeight <= j) {
                    int includeValue = itemValue + matrix[i - 1][j - itemWeight];
                    int excludeValue = matrix[i - 1][j];
                    matrix[i][j] = Math.max(includeValue, excludeValue);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        // Reconstruct chosen items
        List<String> chosen = new ArrayList<>();
        int currentCapacity = capacity;

        for (int i = numberOfItems; i >= 1; i--) {
            // If value changed from row i-1 to i, item i-1 was included
            if (matrix[i][currentCapacity] != matrix[i - 1][currentCapacity]) {
                chosen.add(names[i - 1]);
                currentCapacity -= weights[i - 1];
            }
        }

        Collections.reverse(chosen); // keep same order as input
        return new Result(matrix[numberOfItems][capacity], chosen);
    }

    record Result(int value, List<String> items) {
    }

}
