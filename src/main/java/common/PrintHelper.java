package common;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintHelper {
    public static final Boolean debug = Boolean.TRUE;

    public static String listToStringWithIndex(List<?> list) {
        String string = IntStream
                .range(0, list.size())
                .mapToObj(p -> "(" + p + ") " + (Objects.nonNull(list.get(p)) ? list.get(p).toString() : "null"))
                .collect(Collectors.joining(", ", "[", "]"));
        return string;
    }

    public static String arrayToStringWithIndex(Object[] array) {
        List<Object> list = Arrays.stream(array).toList();
        return listToStringWithIndex(list);
    }

    public static String arrayToStringWithIndex(int[] array) {
        List<Object> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
        return listToStringWithIndex(list);
    }

    public static String listToStringWithoutIndex(List<?> list) {
        String string = IntStream
                .range(0, list.size())
                .mapToObj(p -> (Objects.nonNull(list.get(p)) ? list.get(p).toString() : "null"))
                .collect(Collectors.joining(", ", "[", "]"));
        return string;
    }

    public static String arrayToStringWithoutIndex(Object[] array) {
        List<Object> list = Arrays.stream(array).toList();
        return listToStringWithoutIndex(list);
    }

    public static String arrayToStringWithoutIndex(int[] array) {
        List<Object> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
        return listToStringWithoutIndex(list);
    }
}
