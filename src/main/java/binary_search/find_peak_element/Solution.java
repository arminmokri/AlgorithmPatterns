package binary_search.find_peak_element;

import common.PrintHelper;

public class Solution {

    public int findPeakElement(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithIndex(nums));
        }

        int index = -1;

        int n = nums.length;
        if (n == 1) {
            index = 0;
        } else if (nums[0] > nums[1]) {
            index = 0;
        } else if (nums[n - 2] < nums[n - 1]) {
            index = n - 1;
        }

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                index = mid;
                break;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}
