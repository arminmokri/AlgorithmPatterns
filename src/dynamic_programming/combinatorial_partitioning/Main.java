package dynamic_programming.combinatorial_partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

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

    public static int solution(Integer r, Integer total) {

        int[] ways = new int[total + 1];
        ways[0] = 1;

        List<Integer> steps = new ArrayList<>(
                Arrays.asList(
                        IntStream.range(1, r + 1).boxed().toArray(Integer[]::new)
                )
        );

        // print
        if (debug) {
            System.out.println("steps=" + listToString(steps));
            System.out.println();
        }

        for (int i = 0; i < steps.size(); i++) {

            int step = steps.get(i);

            // print
            if (debug) {
                System.out.println("i=" + i + " step=" + step);
            }

            for (int j = 0; j < ways.length; j++) {
                if (step <= j) {
                    // Update the ways array
                    int index = j - step;
                    ways[j] = ways[j] + ways[index];

                    // print
                    if (debug) {
                        System.out.println("j=" + j + " index=" + index + " ways=" + arrayToString(ways));
                    }
                }
            }

            // print
            if (debug) {
                System.out.println();
            }
        }

        return ways[total];
    }

    public static void main(String[] args) {
        Integer r = 2;
        Integer total = 8;
        int result = solution(r, total);
        System.out.println("Result=" + result);
    }
}
