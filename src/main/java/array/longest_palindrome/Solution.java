package array.longest_palindrome;

import common.PrintHelper;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public int longestPalindrome(String s) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("s=" + s);
        }

        Map<Character, Long> frequency = s.chars()
                .mapToObj(i -> (char) i)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        if (PrintHelper.debug) {
            System.out.println("frequency=" + frequency);
        }

        int longestPalindrome = frequency.values()
                .stream()
                .map(i -> i % 2 == 0 ? i : i - 1)
                .mapToInt(Long::intValue)
                .sum();

        boolean hasOdd = frequency.values()
                .stream()
                .anyMatch(i -> i % 2 != 0);
        if (hasOdd) {
            longestPalindrome = longestPalindrome + 1;
        }

        if (PrintHelper.debug) {
            System.out.println("longestPalindrome=" + longestPalindrome);
        }

        return longestPalindrome;
    }

}
