package binary_search.find_first_and_last_position_of_element_in_sorted_array;

import common.PrintHelper;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithIndex(nums) + " target=" + target);
        }

        int left = 0;
        int right = nums.length - 1;
        int a = -1;
        int b = -1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {

                a = mid;
                while (a >= 0 && nums[a] == nums[mid]) {
                    a--;
                }
                a++;

                b = mid;
                while (b <= nums.length - 1 && nums[b] == nums[mid]) {
                    b++;
                }
                b--;

                break;
            }
        }
        if (PrintHelper.debug) {
            System.out.println("a=" + a + " b=" + b);
        }

        return new int[]{a, b};
    }
}
