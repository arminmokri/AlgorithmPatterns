package array.subarray_sum_equals_k;

import common.PrintHelper;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("k=" + k + " nums=" + PrintHelper.arrayToStringWithIndex(nums));
        }

        return subarraySumA(nums, k);
        //return subarraySumB(nums, k);

    }

    // Time Complexity O(n), Space Complexity O(n)
    private int subarraySumA(int[] nums, int k) {

        Map<Integer, Integer> prefixSums = new HashMap<>();
        int sum = 0;
        int result = 0;

        for (int num : nums) {
            sum = sum + num;

            if (sum == k) {
                result = result + 1;
            }

            if (prefixSums.containsKey(sum - k)) {
                result = result + prefixSums.get(sum - k);
            }

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        if (PrintHelper.debug) {
            System.out.println("prefixSums=" + prefixSums);
        }

        return result;
    }

    // Time Complexity O(n^2), Space Complexity O(1)
    private int subarraySumB(int[] nums, int k) {

        int result = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];

                if (sum == k) {
                    result++;
                }
            }
        }

        return result;
    }


}
