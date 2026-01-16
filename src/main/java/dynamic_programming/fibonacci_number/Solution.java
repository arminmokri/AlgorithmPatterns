package dynamic_programming.fibonacci_number;

import common.PrintHelper;

public class Solution {

    public long fibonacciNumber(int n) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        long[] fibonacci = new long[n + 1];
        fibonacci[0] = 0;
        if (n >= 1) {
            fibonacci[1] = 1;
        }

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci[n];
    }
}
