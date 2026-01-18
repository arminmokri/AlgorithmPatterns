package two_pointer.three_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    // Helper: normalize List<List<Integer>> so order doesn't matter (like assertCountEqual in Python)
    private static List<List<Integer>> normalizeTriplets(List<List<Integer>> triplets) {
        List<List<Integer>> normalized = new ArrayList<>();
        for (List<Integer> t : triplets) {
            List<Integer> sorted = new ArrayList<>(t);
            Collections.sort(sorted);
            normalized.add(sorted);
        }
        normalized.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) return cmp;
            }
            return Integer.compare(a.size(), b.size());
        });
        return normalized;
    }

    private static void assertTripletsEqualIgnoreOrder(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(normalizeTriplets(expected), normalizeTriplets(actual));
    }

    private static List<List<Integer>> ll(int[]... triplets) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] t : triplets) {
            List<Integer> one = new ArrayList<>(t.length);
            for (int v : t) one.add(v);
            res.add(one);
        }
        return res;
    }

    @Test
    public void testDefaultCase() {
        assertTripletsEqualIgnoreOrder(
                ll(new int[]{-1, -1, 2}, new int[]{-1, 0, 1}),
                solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})
        );

        assertTripletsEqualIgnoreOrder(
                Collections.emptyList(),
                solution.threeSum(new int[]{0, 1, 1})
        );

        assertTripletsEqualIgnoreOrder(
                ll(new int[]{0, 0, 0}),
                solution.threeSum(new int[]{0, 0, 0})
        );
    }

    @Test
    public void testMirrorListCase() {
        assertTripletsEqualIgnoreOrder(
                ll(new int[]{-3, 0, 3}, new int[]{-2, 0, 2}),
                solution.threeSum(new int[]{0, -3, -2, 2, 3})
        );
    }

    @Test
    public void testEmptyAndTooShortInputs() {
        assertTripletsEqualIgnoreOrder(
                Collections.emptyList(),
                solution.threeSum(new int[]{})
        );
        assertTripletsEqualIgnoreOrder(
                Collections.emptyList(),
                solution.threeSum(new int[]{0})
        );
        assertTripletsEqualIgnoreOrder(
                Collections.emptyList(),
                solution.threeSum(new int[]{0, 0})
        );
    }

    @Test
    public void testAllPositiveOrAllNegative() {
        assertTripletsEqualIgnoreOrder(
                Collections.emptyList(),
                solution.threeSum(new int[]{1, 2, 3, 4, 5})
        );
        assertTripletsEqualIgnoreOrder(
                Collections.emptyList(),
                solution.threeSum(new int[]{-5, -4, -3, -2, -1})
        );
    }

    @Test
    public void testManyDuplicatesSingleTriplet() {
        assertTripletsEqualIgnoreOrder(
                ll(new int[]{0, 0, 0}),
                solution.threeSum(new int[]{0, 0, 0, 0, 0})
        );

        assertTripletsEqualIgnoreOrder(
                ll(new int[]{-1, -1, 2}),
                solution.threeSum(new int[]{-1, -1, -1, 2, 2, 2})
        );
    }

    @Test
    public void testMultipleTripletsWithDuplicates() {
        // Classic case with duplicates that should not duplicate output triplets
        assertTripletsEqualIgnoreOrder(
                ll(new int[]{-2, 0, 2}),
                solution.threeSum(new int[]{-2, 0, 0, 2, 2})
        );

        assertTripletsEqualIgnoreOrder(
                ll(
                        new int[]{-4, 0, 4},
                        new int[]{-4, 2, 2},
                        new int[]{-2, -2, 4},
                        new int[]{-2, 0, 2}
                ),
                solution.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 4})
        );
    }

    @Test
    public void testUnsortedInputAndOrderIndependence() {
        // Same values, shuffled; result should be the same set of triplets
        int[] nums = new int[]{3, -1, -7, 4, 5, -4, 2, -2, -3, 1, 6};
        List<List<Integer>> expected = ll(
                new int[]{-7, 1, 6},
                new int[]{-7, 2, 5},
                new int[]{-7, 3, 4},
                new int[]{-4, -2, 6},
                new int[]{-4, -1, 5},
                new int[]{-4, 1, 3},
                new int[]{-3, -2, 5},
                new int[]{-3, -1, 4},
                new int[]{-3, 1, 2},
                new int[]{-2, -1, 3}
        );

        assertTripletsEqualIgnoreOrder(expected, solution.threeSum(nums));
    }

    @Test
    public void testLargeMagnitudeNumbers() {
        assertTripletsEqualIgnoreOrder(
                ll(new int[]{-1_000_000_000, 0, 1_000_000_000}),
                solution.threeSum(new int[]{-1_000_000_000, 0, 1_000_000_000})
        );

        assertTripletsEqualIgnoreOrder(
                ll(new int[]{-1_000_000_000, -1_000_000_000, 2_000_000_000}),
                solution.threeSum(new int[]{-1_000_000_000, -1_000_000_000, 2_000_000_000, 1})
        );
    }

    @Test
    public void testTripletsWithZeroAndPairs() {
        assertTripletsEqualIgnoreOrder(
                ll(new int[]{-1, 0, 1}),
                solution.threeSum(new int[]{-1, 0, 1, 0})
        );

        assertTripletsEqualIgnoreOrder(
                ll(
                        new int[]{-3, 0, 3},
                        new int[]{-3, 1, 2},
                        new int[]{-2, -1, 3},
                        new int[]{-2, 0, 2},
                        new int[]{-1, 0, 1}
                ),
                solution.threeSum(new int[]{-2, -1, 0, 1, 2, 3, -3})
        );
    }
}
