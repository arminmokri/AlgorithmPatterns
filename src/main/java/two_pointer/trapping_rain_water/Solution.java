package two_pointer.trapping_rain_water;

import common.PrintHelper;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int trap(int[] height) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("height=" + PrintHelper.arrayToStringWithIndex(height));
        }

        AtomicInteger lastHeighten = new AtomicInteger(0);

        lastHeighten.set(height.length > 0 ? height[0] : 0);
        List<Integer> leftHeighten = IntStream
                .range(0, height.length)
                .boxed()
                .map(index -> {
                    int ret = lastHeighten.get();
                    if (lastHeighten.get() < height[index]) {
                        lastHeighten.set(height[index]);
                    }
                    return ret;
                })
                .collect(Collectors.toList());

        if (PrintHelper.debug) {
            System.out.println("leftHeighten=" + leftHeighten);
        }

        lastHeighten.set(height.length > 0 ? height[height.length - 1] : 0);
        List<Integer> rightHeighten = IntStream
                .range(0, height.length)
                .map(index -> height.length - index - 1)
                .boxed()
                .map(index -> {
                    int ret = lastHeighten.get();
                    if (lastHeighten.get() < height[index]) {
                        lastHeighten.set(height[index]);
                    }
                    return ret;
                })
                .collect(Collectors.toList());
        Collections.reverse(rightHeighten);

        if (PrintHelper.debug) {
            System.out.println("rightHeighten=" + rightHeighten);
        }

        int sum = IntStream.range(0, height.length)
                .map(index -> {
                    int min = Math.min(leftHeighten.get(index), rightHeighten.get(index));
                    int h = (min - height[index]);
                    return h > 0 ? h : 0;
                })
                .sum();

        if (PrintHelper.debug) {
            System.out.println("sum=" + sum);
        }

        return sum;
    }

}
