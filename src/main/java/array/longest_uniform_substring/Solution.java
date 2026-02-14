package array.longest_uniform_substring;

import common.PrintHelper;

public class Solution {

    public int[] repeatedSubstring(String input) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("input=" + input);
        }

        Character maxChar = null;
        int maxLen = Integer.MIN_VALUE;
        int indexStartMax = -1;
        int indexEndMax = -1;

        Character lastChar = null;
        int counter = 0;
        int indexStart = 0;
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);

            if (lastChar != null && c.equals(lastChar)) {
                counter++;
            } else {
                indexStart = i;
                counter = 1;
            }

            if (maxLen < counter) {
                indexStartMax = indexStart;
                indexEndMax = i;
                maxChar = c;
                maxLen = counter;
            }

            lastChar = c;
        }

        if (PrintHelper.debug) {
            System.out.println("indexStartMax=" + indexStartMax);
            System.out.println("indexEndMax=" + indexEndMax);
            System.out.println("maxChar=" + maxChar);
            System.out.println("maxLen=" + maxLen);
        }

        return new int[]{indexStartMax, maxLen};
    }

}
