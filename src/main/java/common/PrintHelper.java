package common;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintHelper {
    public static final Boolean debug = Boolean.TRUE;

    public static String listToString(List<?> list) {
        String string = IntStream
                .range(0, list.size())
                .mapToObj(p -> "(" + p + ") " + (Objects.nonNull(list.get(p)) ? list.get(p).toString() : "null"))
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
}
