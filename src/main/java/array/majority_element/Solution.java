package array.majority_element;

import common.PrintHelper;

public class Solution {

    public int majorityElement(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithoutIndex(nums));
        }

        int candidate = 0;
        int candidateCounter = 0;

        for (int num : nums) {
            if (candidateCounter == 0) {
                candidate = num;
            }

            if (candidate == num) {
                candidateCounter = candidateCounter + 1;
            } else {
                candidateCounter = candidateCounter - 1;
            }
        }

        if (PrintHelper.debug) {
            System.out.println("candidate=" + candidate);
        }

        return candidate;
    }

}
