package dynamic_programming.coin_change_count_ways;

import java.util.Arrays;
import java.util.List;
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

    public static int coinChange(List<Integer> coins, Integer sum) {

        int[] ways = new int[sum + 1];
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

        return ways[sum];
    }
}
