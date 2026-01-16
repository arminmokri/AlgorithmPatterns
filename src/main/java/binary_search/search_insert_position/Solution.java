package binary_search.search_insert_position;

import common.PrintHelper;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToString(nums) + " target=" + target);
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (PrintHelper.debug) {
                System.out.println("left=" + left + " mid=" + mid + " right=" + right);
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
