package dynamic_programming.zero_one_knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"Microscope", "Globe", "Cup", "Crown"},
                new int[]{300, 200, 400, 500},
                new int[]{2, 1, 5, 3},
                10
        );

        assertEquals(1200, result.value());
        assertEquals(Arrays.asList("Microscope", "Cup", "Crown"), result.items());
    }

    @Test
    public void testEmptyItems() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{},
                new int[]{},
                new int[]{},
                10
        );

        assertEquals(0, result.value());
        assertEquals(Collections.emptyList(), result.items());
    }

    @Test
    public void testZeroCapacity() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"Item1"},
                new int[]{100},
                new int[]{1},
                0
        );

        assertEquals(0, result.value());
        assertEquals(Collections.emptyList(), result.items());
    }

    @Test
    public void testSingleItemFits() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"Item1"},
                new int[]{100},
                new int[]{1},
                1
        );

        assertEquals(100, result.value());
        assertEquals(Collections.singletonList("Item1"), result.items());
    }

    @Test
    public void testSingleItemDoesNotFit() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"Item1"},
                new int[]{100},
                new int[]{5},
                3
        );

        assertEquals(0, result.value());
        assertEquals(Collections.emptyList(), result.items());
    }

    @Test
    public void testAllItemsFitExactly() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"A", "B", "C"},
                new int[]{10, 20, 30},
                new int[]{1, 2, 3},
                6
        );

        assertEquals(60, result.value());
        assertEquals(Arrays.asList("A", "B", "C"), result.items());
    }

    @Test
    public void testChooseOptimalCombination() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"A", "B", "C"},
                new int[]{60, 100, 120},
                new int[]{10, 20, 30},
                50
        );

        assertEquals(220, result.value());
        assertEquals(Arrays.asList("B", "C"), result.items());
    }

    @Test
    public void testItemsWithSameWeightAndValue() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"X", "Y", "Z"},
                new int[]{50, 50, 50},
                new int[]{5, 5, 5},
                10
        );

        int totalValue = result.value();
        List<String> selectedItems = result.items();

        assertEquals(100, totalValue);
        assertEquals(2, selectedItems.size());

        Set<String> allowed = new HashSet<>(Arrays.asList("X", "Y", "Z"));
        assertTrue(allowed.containsAll(selectedItems));
    }

    @Test
    public void testDuplicateBestValue() {
        Solution.Result result = solution.knapsackTabulation(
                new String[]{"Pen", "Notebook", "Calculator", "Book"},
                new int[]{10, 40, 50, 70},
                new int[]{1, 3, 4, 5},
                8
        );

        assertEquals(110, result.value());
        assertEquals(Arrays.asList("Notebook", "Book"), result.items());
    }

    @Test
    public void testLargeInputRecursionLimit() {
        String[] items = new String[30];
        int[] values = new int[30];
        int[] weights = new int[30];
        int capacity = 300;

        for (int i = 0; i < 30; i++) {
            items[i] = "Item" + i;
            values[i] = i * 10;
            weights[i] = i + 1;
        }

        // Recursive solution will be extremely slow or hit recursion limits
        // Tabulation / memoized solution should solve this
        Solution.Result result = solution.knapsackTabulation(items, values, weights, capacity);

        assertEquals(2870, result.value());
    }

}
