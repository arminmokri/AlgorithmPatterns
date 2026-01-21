package array.product_of_array_except_self;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithIndex(nums));
        }

        List<Integer> prefix = new ArrayList<>();
        prefix.add(1);
        IntStream.range(0, nums.length - 1)
                .reduce(1, (multiple, i) -> {
                    multiple = multiple * nums[i];
                    prefix.add(multiple);
                    return multiple;
                });

        if (PrintHelper.debug) {
            System.out.println("prefix=" + prefix);
        }

        List<Integer> suffix = new ArrayList<>();
        suffix.addFirst(1);
        IntStream.range(0, nums.length - 1)
                .map(i -> nums.length - i - 1)
                .reduce(1, (multiple, i) -> {
                    multiple = multiple * nums[i];
                    suffix.addFirst(multiple);
                    return multiple;
                });

        if (PrintHelper.debug) {
            System.out.println("suffix=" + suffix);
        }

        int[] product = IntStream.range(0, nums.length)
                .map(i -> prefix.get(i) * suffix.get(i))
                .toArray();

        return product;
    }

}
