package sliding_window.minimum_window_substring;

import common.PrintHelper;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public String minWindow(String s, String t) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("s=" + s + " t=" + t);
        }


        if (s.equals(t)) {
            return s;
        } else if (t.length() > s.length()) {
            return "";
        }

        AtomicReference<String> min = new AtomicReference<>("");
        IntStream.rangeClosed(t.length(), s.length())
                .boxed()
                .flatMap(
                        len -> IntStream.rangeClosed(0, s.length() - len)
                                .mapToObj(start -> s.substring(start, start + len))
                )
                .anyMatch(str -> {
                    boolean b = isStringBInStringA(str, t);
                    if (b) {
                        min.set(str);
                    }
                    return b;
                });


        return min.get();
    }

    private boolean isStringBInStringA(String stringA, String stringB) {

        Map<Character, Long> frequentStringA = stringA.chars()
                .mapToObj(i -> (char) i)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        AtomicBoolean isStringBInStringA = new AtomicBoolean(true);
        stringB.chars()
                .mapToObj(i -> (char) i)
                .takeWhile(i -> isStringBInStringA.get())
                .forEach(character -> {
                    if (frequentStringA.getOrDefault(character, 0L) > 0) {
                        Long val = frequentStringA.get(character);
                        val = val - 1;
                        frequentStringA.put(character, val);
                    } else {
                        isStringBInStringA.set(false);
                    }
                });


        return isStringBInStringA.get();

    }

}
