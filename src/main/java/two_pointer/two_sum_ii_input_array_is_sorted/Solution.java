package two_pointer.two_sum_ii_input_array_is_sorted;

import common.PrintHelper;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        int[] result = new int[]{-1, -1};

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum > target) {
                right = right - 1;
            } else if (sum < target) {
                left = left + 1;
            }
        }

        return result;
    }

}
