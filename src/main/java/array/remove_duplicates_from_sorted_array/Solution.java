package array.remove_duplicates_from_sorted_array;

import common.PrintHelper;

public class Solution {


    public int removeDuplicates(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithIndex(nums));
        }

        int uniqueIndex = nums.length > 0 ? 1 : 0;
        int previousItem = nums.length > 0 ? nums[0] : 0;
        for (int i = 1; i < nums.length; i++) {
            if (previousItem != nums[i]) {
                nums[uniqueIndex] = nums[i];
                previousItem = nums[i];
                uniqueIndex++;
            }
        }

        for (int i = uniqueIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println("nums=" + PrintHelper.arrayToStringWithIndex(nums));

        return uniqueIndex;

    }

}
