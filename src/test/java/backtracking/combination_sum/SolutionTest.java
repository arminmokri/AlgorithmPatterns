package backtracking.combination_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    // Helper to compare combinations ignoring order of combinations and order within each combination
    private static List<List<Integer>> normalize(List<List<Integer>> combos) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> c : combos) {
            List<Integer> sorted = new ArrayList<>(c);
            Collections.sort(sorted);
            copy.add(sorted);
        }
        copy.sort((a, b) -> {
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) return cmp;
            }
            return Integer.compare(a.size(), b.size());
        });
        return copy;
    }

    private static void assertCombinationsEqual(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(normalize(expected), normalize(actual));
    }

    @Test
    public void testDefaultCase() {
        assertCombinationsEqual(
                Arrays.asList(
                        Arrays.asList(2, 2, 3),
                        Arrays.asList(7)
                ),
                solution.combinationSum(new int[]{2, 3, 6, 7}, 7)
        );

        assertCombinationsEqual(
                Arrays.asList(
                        Arrays.asList(2, 2, 2, 2),
                        Arrays.asList(2, 3, 3),
                        Arrays.asList(3, 5)
                ),
                solution.combinationSum(new int[]{2, 3, 5}, 8)
        );

        assertCombinationsEqual(
                Collections.emptyList(),
                solution.combinationSum(new int[]{2}, 1)
        );
    }

    @Test
    public void testSingleExactMatch() {
        assertCombinationsEqual(
                Arrays.asList(Arrays.asList(5)),
                solution.combinationSum(new int[]{5}, 5)
        );
    }

    @Test
    public void testNoPossibleCombination() {
        assertCombinationsEqual(
                Collections.emptyList(),
                solution.combinationSum(new int[]{4, 6}, 5)
        );
    }

    @Test
    public void testMultipleCandidatesUnsortedInput() {
        assertCombinationsEqual(
                Arrays.asList(
                        Arrays.asList(1, 1, 1, 1),
                        Arrays.asList(1, 3)
                ),
                solution.combinationSum(new int[]{8, 1, 3}, 4)
        );
    }

    @Test
    public void testTargetZero() {
        assertCombinationsEqual(
                Collections.emptyList(),
                solution.combinationSum(new int[]{1, 2, 3}, 0)
        );

        // Python test printed the result; keeping an equivalent print here (optional)
        System.out.println(solution.combinationSum(new int[]{1, 2, 3}, 0));
    }

    @Test
    public void testLargeTargetSmallNumbers() {
        assertCombinationsEqual(
                Arrays.asList(
                        Arrays.asList(1, 1, 1, 1, 1),
                        Arrays.asList(1, 1, 1, 2),
                        Arrays.asList(1, 2, 2)
                ),
                solution.combinationSum(new int[]{1, 2}, 5)
        );
    }

    @Test
    public void testSingleCandidateMultipleTimes() {
        assertCombinationsEqual(
                Arrays.asList(Arrays.asList(3, 3, 3)),
                solution.combinationSum(new int[]{3}, 9)
        );
    }
}
