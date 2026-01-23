package backtracking.permutations;

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
        assertEquals(
                toSet(new int[][]{
                        {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}
                }),
                normalize(solution.permute(new int[]{1, 2, 3}))
        );

        assertEquals(
                toSet(new int[][]{{0, 1}, {1, 0}}),
                normalize(solution.permute(new int[]{0, 1}))
        );

        assertEquals(
                toSet(new int[][]{{1}}),
                normalize(solution.permute(new int[]{1}))
        );
    }

    @Test
    public void testEmptyList() {
        assertEquals(
                toSet(new int[][]{{}}), // represents [[]]
                normalize(solution.permute(new int[]{}))
        );
    }

    @Test
    public void testWithNegativeNumbers() {
        assertEquals(
                toSet(new int[][]{
                        {-1, 0, 1}, {-1, 1, 0}, {0, -1, 1}, {0, 1, -1}, {1, -1, 0}, {1, 0, -1}
                }),
                normalize(solution.permute(new int[]{-1, 0, 1}))
        );
    }

    @Test
    public void testFourElements() {
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3, 4});
        assertEquals(24, result.size());
        assertTrue(result.contains(Arrays.asList(4, 3, 2, 1)));
    }

    // --- helpers: mimic Python's assertCountEqual for list-of-lists ---

    private static Set<List<Integer>> normalize(List<List<Integer>> actual) {
        return new HashSet<>(actual);
    }

    private static Set<List<Integer>> toSet(int[][] expected) {
        Set<List<Integer>> set = new HashSet<>();
        for (int[] row : expected) {
            List<Integer> list = new ArrayList<>();
            for (int v : row) list.add(v);
            set.add(list);
        }
        return set;
    }
}
