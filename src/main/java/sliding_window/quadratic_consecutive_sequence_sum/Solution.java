package sliding_window.quadratic_consecutive_sequence_sum;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public String quadraticConsecutiveSequenceSum(int x) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("x=" + x);
        }

        List<List<Integer>> sequenceList = IntStream
                .rangeClosed(1, x)
                .mapToObj(
                        i -> {
                            int sum = 0;
                            List<Integer> list = new ArrayList<>();
                            for (int j = i; j <= x; j++) {
                                sum = sum + (int) Math.pow(j, 2);
                                list.add(j);
                                if (sum == x) {
                                    break;
                                } else if (sum > x) {
                                    list.clear();
                                    break;
                                }
                            }
                            return list;
                        }
                )
                .filter(list -> !list.isEmpty())
                .collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("\"count: " + sequenceList.size() + "\"");
        if (sequenceList.size() > 0) {
            stringBuilder.append(", ");
            String s = sequenceList
                    .stream()
                    .map(
                            list -> list
                                    .stream()
                                    .map(i -> String.valueOf(i))
                                    .collect(Collectors.joining(" ", "\"", "\""))
                    )
                    .collect(Collectors.joining(", "));
            stringBuilder.append(s);
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
