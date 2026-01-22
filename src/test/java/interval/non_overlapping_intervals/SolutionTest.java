package interval.non_overlapping_intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {

        assertEquals(
                1,
                solution.eraseOverlapIntervals(new int[][]{
                                {1, 2},
                                {2, 3},
                                {3, 4},
                                {1, 3}
                        }
                )
        );

        assertEquals(
                2,
                solution.eraseOverlapIntervals(new int[][]{
                                {1, 2},
                                {1, 2},
                                {1, 2}
                        }
                )
        );

        assertEquals(
                0,
                solution.eraseOverlapIntervals(new int[][]{
                                {1, 2},
                                {2, 3}
                        }
                )
        );
    }

    @Test
    public void testAlreadyNonOverlapping_UnsortedInput() {
        // Unsorted but non-overlapping when ordered by time
        assertEquals(
                0,
                solution.eraseOverlapIntervals(new int[][]{
                        {5, 6},
                        {1, 2},
                        {3, 4},
                        {2, 3}
                })
        );
    }

    @Test
    public void testSingleInterval() {
        assertEquals(
                0,
                solution.eraseOverlapIntervals(new int[][]{
                        {10, 20}
                })
        );
    }

    @Test
    public void testAllIdenticalIntervals() {
        // Keep 1, remove the rest
        assertEquals(
                4,
                solution.eraseOverlapIntervals(new int[][]{
                        {1, 2},
                        {1, 2},
                        {1, 2},
                        {1, 2},
                        {1, 2}
                })
        );
    }

    @Test
    public void testNestedIntervals_KeepShortestEnd() {
        // Optimal: keep {2,3} (or {3,4} etc.), remove others that cover it
        assertEquals(
                1,
                solution.eraseOverlapIntervals(new int[][]{
                        {1, 10},
                        {2, 3},
                        {3, 4}
                })
        );
    }

    @Test
    public void testChainOverlaps() {
        // [1,3] overlaps [2,4]; [2,4] overlaps [3,5]; optimal removals = 1
        assertEquals(
                1,
                solution.eraseOverlapIntervals(new int[][]{
                        {1, 3},
                        {2, 4},
                        {3, 5}
                })
        );
    }

    @Test
    public void testManySameStartDifferentEnd() {
        // Best is to keep the one with smallest end {1,2}
        assertEquals(
                3,
                solution.eraseOverlapIntervals(new int[][]{
                        {1, 5},
                        {1, 4},
                        {1, 3},
                        {1, 2}
                })
        );
    }

    @Test
    public void testManySameEndDifferentStart() {
        // Best is to keep the one with latest start {4,5}
        assertEquals(
                3,
                solution.eraseOverlapIntervals(new int[][]{
                        {1, 5},
                        {2, 5},
                        {3, 5},
                        {4, 5}
                })
        );
    }

    @Test
    public void testTouchingEndpoints_NoOverlap() {
        // Touching at endpoints is NOT overlap for this problem (end == nextStart is OK)
        assertEquals(
                0,
                solution.eraseOverlapIntervals(new int[][]{
                        {1, 2},
                        {2, 2},
                        {2, 3},
                        {3, 4}
                })
        );
    }

    @Test
    public void testNegativeCoordinates_Mixed() {
        assertEquals(
                1,
                solution.eraseOverlapIntervals(new int[][]{
                        {-3, -1},
                        {-2, 1},
                        {1, 2}
                })
        );
    }

    @Test
    public void testLargeRangeWithSmallInside() {
        // Keep small disjoint ones: {2,3}, {3,4}, {4,5} => remove the big {1,100}
        assertEquals(
                1,
                solution.eraseOverlapIntervals(new int[][]{
                        {1, 100},
                        {2, 3},
                        {3, 4},
                        {4, 5}
                })
        );
    }
}
