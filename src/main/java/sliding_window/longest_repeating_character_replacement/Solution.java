package sliding_window.longest_repeating_character_replacement;

import common.PrintHelper;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int characterReplacement(String s, int k) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("s=" + s + " k=" + k);
        }

        if (k >= (s.length() - 1)) {
            return s.length();
        }

        AtomicInteger max = new AtomicInteger();

        IntStream.iterate(s.length(), len -> len >= k + 1, len -> len - 1)
                .boxed()
                .flatMap(len ->
                        IntStream.rangeClosed(0, s.length() - len)
                                .mapToObj(start -> s.substring(start, start + len))
                )
                .peek(System.out::println)
                .anyMatch(str -> {
                    boolean b = othersCharsHasKDiffWithMainChar(str, k);
                    if (b) {
                        max.set(str.length());
                    }
                    return b;
                });

        return max.get();
    }

    private boolean othersCharsHasKDiffWithMainChar(String s, int k) {

        Map<Character, Long> frequency = s.chars()
                .mapToObj(i -> (char) i)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        Map.Entry<Character, Long> max = frequency.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElse(null);

        long sumOfOthersChars = frequency.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(max.getKey()))
                .mapToLong(entry -> entry.getValue())
                .sum();

        return k >= sumOfOthersChars;
    }

}
