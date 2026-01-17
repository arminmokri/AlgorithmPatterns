package common;

import java.util.ArrayList;
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

    public static String matrixToString(List<? extends List<?>> matrix) {
        if (matrix.isEmpty()) {
            return "[]";
        }
        if (matrix.size() == 1 && matrix.get(0).isEmpty()) {
            return "[[]]";
        }

        // Convert all values to strings and find max width
        int maxWidth = 0;
        String[][] strMatrix = new String[matrix.size()][];

        for (int i = 0; i < matrix.size(); i++) {
            List<?> row = matrix.get(i);
            strMatrix[i] = new String[row.size()];
            for (int j = 0; j < row.size(); j++) {
                String val = String.valueOf(row.get(j));
                strMatrix[i][j] = val;
                maxWidth = Math.max(maxWidth, val.length());
            }
        }

        // Build formatted output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strMatrix.length; i++) {
            sb.append("[ ");
            for (int j = 0; j < strMatrix[i].length; j++) {
                sb.append(String.format("%" + maxWidth + "s", strMatrix[i][j]));
                if (j < strMatrix[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            if (i < strMatrix.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public static String matrixToString(Object[][] matrix) {
        List<List<Object>> result = new ArrayList<>();

        for (Object[] row : matrix) {
            List<Object> listRow = new ArrayList<>();
            if (row != null) {
                for (Object val : row) {
                    listRow.add(val);
                }
            }
            result.add(listRow);
        }
        return matrixToString(result);
    }
}
