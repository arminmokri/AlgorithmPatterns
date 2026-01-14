package array.monotonic_array;

import common.PrintHelper;

public class Solution {


    public boolean isMonotonic(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToString(nums));
        }

        boolean isMonotonic = true;

        int firstItem = nums.length > 0 ? nums[0] : 0;
        int lastItem = nums.length > 0 ? nums[nums.length - 1] : 0;

        boolean isAscending;
        if (firstItem <= lastItem) {
            isAscending = true;
        } else {
            isAscending = false;
        }

        int previousItem = firstItem;
        for (int i = 1; i < nums.length; i++) {
            int currentItem = nums[i];
            if (isAscending && previousItem > currentItem) {
                isMonotonic = false;
                break;
            } else if (!isAscending && previousItem < currentItem) {
                isMonotonic = false;
                break;
            }
            previousItem = currentItem;
        }

        if (PrintHelper.debug) {
            System.out.println("isMonotonic=" + isMonotonic);
        }

        return isMonotonic;

    }

}
