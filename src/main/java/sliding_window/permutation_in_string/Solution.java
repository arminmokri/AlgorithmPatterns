package sliding_window.permutation_in_string;

import common.PrintHelper;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        System.out.println("s1=" + s1 + " s2=" + s2);

        Map<Character, Long> s1Frequent =
                s1.chars()
                        .mapToObj(i -> (char) i)
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.counting()
                                )
                        );

        Predicate<String> isPermutation = stringB ->
                s1Frequent.equals(
                        stringB.chars()
                                .mapToObj(i -> (char) i)
                                .collect(
                                        Collectors.groupingBy(
                                                Function.identity(),
                                                Collectors.counting()
                                        )
                                )
                );

        boolean checkInclusion = IntStream.rangeClosed(0, s2.length() - s1.length())
                .mapToObj(i -> s2.substring(i, i + s1.length()))
                .distinct()
                .anyMatch(s -> isPermutation.test(s));

        return checkInclusion;
    }

}
