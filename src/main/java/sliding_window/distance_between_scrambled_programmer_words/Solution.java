package sliding_window.distance_between_scrambled_programmer_words;

import common.PrintHelper;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int distanceBetweenWords(String string) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        String programmer = "programmer";

        List<Character> programmerListBegin = Collections.synchronizedList(
                programmer
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList())
        );
        List<Character> programmerListEnd = Collections.synchronizedList(
                programmer
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList())
        );

        AtomicInteger diff = new AtomicInteger(string.length());
        IntStream.range(0, string.length())
                .boxed()
                .takeWhile(i -> !programmerListBegin.isEmpty())
                .forEach(i -> {
                    Character character = string.charAt(i);
                    programmerListBegin.remove(character);
                    diff.decrementAndGet();
                });

        IntStream.range(0, string.length())
                .map(i -> string.length() - 1 - i)
                .boxed()
                .takeWhile(i -> !programmerListEnd.isEmpty())
                .forEach(i -> {
                    Character character = string.charAt(i);
                    programmerListEnd.remove(character);
                    diff.decrementAndGet();
                });

        return diff.get() >= 0 ? diff.get() : 0;
    }

}
