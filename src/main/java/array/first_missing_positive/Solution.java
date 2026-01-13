package array.first_missing_positive;

import common.PrintHelper;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        Set<Integer> setNums = new HashSet();
        for (int num : nums) {
            if (num > 0) {
                setNums.add(num);
            }
        }

        int firstMissingPositive = 1;
        while (setNums.contains(firstMissingPositive)) {
            firstMissingPositive++;
        }

        return firstMissingPositive;
    }
}
