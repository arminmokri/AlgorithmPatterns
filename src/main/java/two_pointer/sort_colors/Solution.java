package two_pointer.sort_colors;

import common.PrintHelper;

public class Solution {

    /**
     * Do not return anything, modify nums in-place instead.
     */
    public void sortColors(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (mid <= right) {

            if (PrintHelper.debug) {
                System.out.println(
                        "left=" + left + " mid=" + mid + " right=" + right
                                + " num=" + PrintHelper.arrayToStringWithIndex(nums)
                );
            }

            if (nums[mid] == 0) {
                swap(nums, left, mid);
                mid = mid + 1;
                left = left + 1;
            } else if (nums[mid] == 1) {
                mid = mid + 1;
            } else if (nums[mid] == 2) {
                swap(nums, mid, right);
                right = right - 1;
            }
        }
    }

    private void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

}
