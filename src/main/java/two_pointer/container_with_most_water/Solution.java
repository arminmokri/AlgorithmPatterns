package two_pointer.container_with_most_water;

import common.PrintHelper;

public class Solution {


    public int maxArea(int[] height) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            maxArea = Math.max(maxArea, area);

            if (height[left] > height[right]) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }

        return maxArea;
    }
}
