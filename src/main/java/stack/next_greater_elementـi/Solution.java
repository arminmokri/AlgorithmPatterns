package stack.next_greater_elementـi;

import common.PrintHelper;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums1=" + PrintHelper.arrayToStringWithoutIndex(nums1));
            System.out.println("nums2=" + PrintHelper.arrayToStringWithoutIndex(nums2));
        }

        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            if (stack.isEmpty()) {
                nextGreater.put(num, -1);
            } else if (num < stack.peek()) {
                nextGreater.put(num, stack.peek());
            } else {
                while (!stack.isEmpty() && num > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nextGreater.put(num, -1);
                } else {
                    nextGreater.put(num, stack.peek());
                }
            }
            stack.push(num);
        }

        if (PrintHelper.debug) {
            System.out.println("nextGreater=" + nextGreater);
        }

        int[] nextGreaterElement = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nextGreaterElement[i] = nextGreater.get(nums1[i]);
        }

        if (PrintHelper.debug) {
            System.out.println("nextGreaterElement=" + PrintHelper.arrayToStringWithoutIndex(nextGreaterElement));
        }

        return nextGreaterElement;
    }

}
