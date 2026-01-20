package sliding_window.longest_substring_without_repeating_characters;

import common.PrintHelper;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        Predicate<String> hasAllUniqueChars =
                str -> str.codePoints().distinct().count() == str.length();

        int lengthOfLongestSubstring = IntStream
                .range(0, s.length())
                .boxed()
                .flatMap(
                        i -> IntStream
                                .range(i + 1, s.length() + 1)
                                .mapToObj(j -> s.substring(i, j))
                )
                .filter(hasAllUniqueChars)
                .mapToInt(string -> string.length())
                .max().orElse(0);

        return lengthOfLongestSubstring;
    }

}
