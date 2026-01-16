package binary_search.binary_search;

import common.PrintHelper;

public class Solution {

    public int search(int[] nums, int target) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithIndex(nums) + " target=" + target);
        }

        int left = 0;
        int right = nums.length - 1;
        int indexTarget = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (PrintHelper.debug) {
                System.out.println("left=" + left + " mid=" + mid + " right=" + right);
            }

            if (nums[mid] == target) {
                indexTarget = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return indexTarget;
    }
}
