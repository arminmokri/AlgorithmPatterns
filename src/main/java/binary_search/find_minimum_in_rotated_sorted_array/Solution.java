package binary_search.find_minimum_in_rotated_sorted_array;

import common.PrintHelper;

public class Solution {

    public int findMin(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToString(nums));
        }

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (PrintHelper.debug) {
                System.out.println("left=" + left + " mid=" + mid + " right=" + right);
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (PrintHelper.debug) {
            System.out.println("min=" + min);
        }

        return nums[left];
    }
}
