package array.missing_number;

import common.PrintHelper;

import java.util.Arrays;

public class Solution {

    public int missingNumber(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithoutIndex(nums));
        }

        // sum of 1, 2, 3, 4, ..., n is equal to (n*(n+1))/2
        int sumMustBe = (nums.length * (nums.length + 1)) / 2;
        int sum = Arrays.stream(nums)
                .sum();
        int missingNumber = sumMustBe - sum;

        if (PrintHelper.debug) {
            System.out.println("sumMustBe=" + sumMustBe + ""
                    + " sum=" + sum
                    + " missingNumber=" + missingNumber);
        }

        return missingNumber;
    }

}
