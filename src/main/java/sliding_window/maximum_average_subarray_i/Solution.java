package sliding_window.maximum_average_subarray_i;

import common.PrintHelper;

import java.util.stream.IntStream;

public class Solution {

    public float findMaxAverage(int[] nums, int k) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        double findMaxAverage = IntStream
                .rangeClosed(0, nums.length - k)
                .boxed()
                .mapToDouble(
                        index -> IntStream.range(index, index + k)
                                .boxed()
                                .mapToInt(i -> nums[i])
                                .average()
                                .orElse(Double.MAX_VALUE)
                )
                .max()
                .orElse(0);


        return (float) findMaxAverage;
    }

}
