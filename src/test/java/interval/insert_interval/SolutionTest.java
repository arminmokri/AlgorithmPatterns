package interval.insert_interval;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    private static List<List<Integer>> intervals(int[][] arr) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] p : arr) {
            res.add(Arrays.asList(p[0], p[1]));
        }
        return res;
    }

    @Test
    public void testDefaultCase() {
        assertEquals(
                intervals(new int[][]{{1, 5}, {6, 9}}),
                solution.insert(intervals(new int[][]{{1, 3}, {6, 9}}), Arrays.asList(2, 5))
        );

        assertEquals(
                intervals(new int[][]{{1, 2}, {3, 10}, {12, 16}}),
                solution.insert(
                        intervals(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}),
                        Arrays.asList(4, 8)
                )
        );
    }

    @Test
    public void testInsertBeforeAll() {
        assertEquals(
                intervals(new int[][]{{1, 3}, {5, 7}, {8, 12}}),
                solution.insert(intervals(new int[][]{{5, 7}, {8, 12}}), Arrays.asList(1, 3))
        );
    }

    @Test
    public void testInsertAfterAll() {
        assertEquals(
                intervals(new int[][]{{1, 2}, {3, 5}, {6, 8}}),
                solution.insert(intervals(new int[][]{{1, 2}, {3, 5}}), Arrays.asList(6, 8))
        );
    }

    @Test
    public void testInsertOverlappingMultiple() {
        assertEquals(
                intervals(new int[][]{{1, 9}}),
                solution.insert(intervals(new int[][]{{1, 3}, {4, 6}, {7, 9}}), Arrays.asList(2, 8))
        );
    }

    @Test
    public void testInsertOverlappingAll() {
        assertEquals(
                intervals(new int[][]{{1, 10}}),
                solution.insert(intervals(new int[][]{{2, 3}, {4, 5}, {6, 7}}), Arrays.asList(1, 10))
        );
    }

    @Test
    public void testInsertExactMatch() {
        assertEquals(
                intervals(new int[][]{{1, 2}, {3, 4}}),
                solution.insert(intervals(new int[][]{{1, 2}, {3, 4}}), Arrays.asList(3, 4))
        );
    }

    @Test
    public void testInsertIntoEmptyList() {
        assertEquals(
                intervals(new int[][]{{5, 7}}),
                solution.insert(intervals(new int[][]{}), Arrays.asList(5, 7))
        );
    }

    @Test
    public void testInsertBetweenNonOverlapping() {
        assertEquals(
                intervals(new int[][]{{1, 2}, {4, 6}, {8, 10}}),
                solution.insert(intervals(new int[][]{{1, 2}, {8, 10}}), Arrays.asList(4, 6))
        );
    }

    @Test
    public void testInsertFullyContained() {
        assertEquals(
                intervals(new int[][]{{1, 10}}),
                solution.insert(intervals(new int[][]{{1, 10}}), Arrays.asList(3, 5))
        );
    }
}
