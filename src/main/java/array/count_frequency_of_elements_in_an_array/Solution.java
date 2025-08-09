package array.count_frequency_of_elements_in_an_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static final Boolean debug = Boolean.TRUE;

    public static String listToString(List<?> list) {
        String string = IntStream
                .range(0, list.size())
                .mapToObj(p -> "(" + p + ") " + list.get(p).toString())
                .collect(Collectors.joining(", ", "[", "]"));
        return string;
    }

    public static String arrayToString(Object[] array) {
        List<Object> list = Arrays.stream(array).toList();
        return listToString(list);
    }

    public static String arrayToString(int[] array) {
        List<Object> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
        return listToString(list);
    }

    private Map<String, Long> countFrequencyOfElementsInAnArrayA(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    private Map<String, Long> countFrequencyOfElementsInAnArrayB(List<String> list) {
        Map<String, Long> map = new HashMap<>();

        list.stream()
                .forEach(s -> map.put(s, map.getOrDefault(s, 0L) + 1));

        return map;
    }

    public Map<String, Long> countFrequencyOfElementsInAnArray(List<String> list) {
        return countFrequencyOfElementsInAnArrayA(list);
    }
}
