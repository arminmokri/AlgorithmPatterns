package dynamic_programming.coin_change_count_ways;

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

    public static int solution(Integer N, List<Integer> coins) {

        int[] ways = new int[N + 1];
        ways[0] = 1;

        // print
        if (debug) {
            System.out.println("coins=" + listToString(coins));
            System.out.println();
        }

        for (int i = 0; i < coins.size(); i++) {

            int coin = coins.get(i);

            // print
            if (debug) {
                System.out.println("i=" + i + " coin=" + coin);
            }

            for (int j = 0; j < ways.length; j++) {
                if (coin <= j) {
                    // Update the ways array
                    int index = j - coin;
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

        return ways[N];
    }

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>(Arrays.asList(1, 2, 5, 10));
        Integer N = 12;
        int result = solution(N, coins);
        System.out.println("Result=" + result);
    }
}
