package interval.minimum_number_of_arrows_to_burst_balloons;

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
    public void testFindMinArrowShots_singleBalloon() {
        assertEquals(
                1,
                solution.findMinArrowShots(new int[][]{
                        {5, 7}
                })
        );
    }

    @Test
    public void testFindMinArrowShots_allOverlapping() {
        // All intervals overlap at point 4 (or any point between 3 and 4)
        assertEquals(
                1,
                solution.findMinArrowShots(new int[][]{
                        {1, 10},
                        {2, 9},
                        {3, 8},
                        {4, 7}
                })
        );
    }

    @Test
    public void testFindMinArrowShots_touchingEndpointsShouldShareArrow() {
        // Touching endpoints: [1,2] and [2,2] and [2,3] can all be burst with one arrow at x=2
        assertEquals(
                1,
                solution.findMinArrowShots(new int[][]{
                        {1, 2},
                        {2, 2},
                        {2, 3}
                })
        );
    }

    @Test
    public void testFindMinArrowShots_unsortedInputMixedOverlaps() {
        // Overlap groups:
        // Group1: [1,5], [2,6], [4,7] -> 1 arrow
        // Group2: [8,10], [9,12] -> 1 arrow
        // Group3: [13,14] -> 1 arrow
        assertEquals(
                3,
                solution.findMinArrowShots(new int[][]{
                        {9, 12},
                        {13, 14},
                        {4, 7},
                        {2, 6},
                        {8, 10},
                        {1, 5}
                })
        );
    }

    @Test
    public void testFindMinArrowShots_duplicateIntervals() {
        assertEquals(
                1,
                solution.findMinArrowShots(new int[][]{
                        {1, 3},
                        {1, 3},
                        {1, 3}
                })
        );
    }

    @Test
    public void testFindMinArrowShots_negativeCoordinates() {
        // Group1: [-10,-1], [-5,0], [-3,-2] overlap -> 1 arrow
        // Group2: [1,2] -> 1 arrow
        assertEquals(
                2,
                solution.findMinArrowShots(new int[][]{
                        {-10, -1},
                        {-5, 0},
                        {-3, -2},
                        {1, 2}
                })
        );
    }

    @Test
    public void testFindMinArrowShots_largeValueBoundaries() {
        // Classic boundary case: ensure no overflow in sorting/comparisons
        assertEquals(
                2,
                solution.findMinArrowShots(new int[][]{
                        {-2147483648, -2147483647},
                        {2147483646, 2147483647},
                        {2147483645, 2147483646} // overlaps with [2147483646,2147483647] at x=2147483646
                })
        );
    }

    @Test
    public void testFindMinArrowShots_manyDisjointIncludingPoints() {
        // Point balloons mixed with disjoint ranges
        assertEquals(
                5,
                solution.findMinArrowShots(new int[][]{
                        {1, 1},
                        {2, 2},
                        {3, 3},
                        {10, 11},
                        {12, 13}
                })
        );
    }
}
