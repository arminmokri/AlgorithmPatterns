package dynamic_programming.fibonacci_number;

import common.PrintHelper;

public class Solution {

    public long fibonacciNumber(int n) {
        if (PrintHelper.debug) {
            System.out.println();
        }
        //return recursion(n);
        //return memoization(n, new long[n + 1]);
        return bottomUp(n);
    }

    private long recursion(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursion(n - 1) + recursion(n - 2);
        }
    }

    private long memoization(int n, long[] fibonacci) {
        if (fibonacci[n] != 0) {
            return fibonacci[n];
        }

        long result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = memoization(n - 1, fibonacci) + memoization(n - 2, fibonacci);
        }
        fibonacci[n] = result;
        return result;
    }

    private long bottomUp(int n) {
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
