package binary_search.search_in_rotated_sorted_array;

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

            String s = "left=" + left + " mid=" + mid + " right=" + right;


            if (nums[mid] == target) {
                indexTarget = mid;
                break;
            } else if (nums[left] <= nums[mid]) { // Left half is sorted
                s = s + ", left half is sorted";
                if (nums[left] <= target && target < nums[mid]) { // target between left and mid
                    s = s + ", target is in left half";
                    right = mid - 1;
                } else {
                    s = s + ", target is in right half";
                    left = mid + 1;
                }
            } else { // Right half is sorted
                s = s + ", right half is sorted";
                if (nums[mid] < target && target <= nums[right]) { // target between mid and right
                    s = s + ", target is in right half";
                    left = mid + 1;
                } else {
                    s = s + ", target is in left half";
                    right = mid - 1;
                }
            }

            if (PrintHelper.debug) {
                System.out.println(s);
            }
        }
        return indexTarget;
    }
}
