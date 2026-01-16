package array.valid_anagram;

import common.PrintHelper;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] frequentList = new int[256];

        IntStream.range(0, s.length())
                .boxed()
                .forEachOrdered(i -> {
                    frequentList[(int) s.charAt(i)]++;
                    frequentList[(int) t.charAt(i)]--;
                });

        if (PrintHelper.debug) {
            System.out.println("frequentList=" + PrintHelper.arrayToStringWithoutIndex(frequentList));
        }

        boolean findNoneZero = Arrays.stream(frequentList)
                .anyMatch(i -> i != 0);
        boolean isAnagram = !findNoneZero;

        if (PrintHelper.debug) {
            System.out.println("isAnagram=" + isAnagram);
        }

        return isAnagram;
    }

}
