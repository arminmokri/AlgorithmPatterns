package array.monotonic_array;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertTrue(solution.isMonotonic(new int[]{1, 2, 2, 3}));
        assertTrue(solution.isMonotonic(new int[]{6, 5, 4, 4}));
        assertFalse(solution.isMonotonic(new int[]{1, 3, 2}));
    }

    @Test
    public void testEdgeCases() {
        // Empty array is trivially monotonic
        assertTrue(solution.isMonotonic(new int[]{}));

        // Single element is always monotonic
        assertTrue(solution.isMonotonic(new int[]{10}));

        // Two elements (increasing)
        assertTrue(solution.isMonotonic(new int[]{1, 2}));

        // Two elements (decreasing)
        assertTrue(solution.isMonotonic(new int[]{2, 1}));

        // All elements equal (constant)
        assertTrue(solution.isMonotonic(new int[]{3, 3, 3, 3}));
    }

    @Test
    public void testNotMonotonic() {
        // Increasing then decreasing
        assertFalse(solution.isMonotonic(new int[]{1, 3, 2}));

        // Decreasing then increasing
        assertFalse(solution.isMonotonic(new int[]{5, 3, 4}));

        // Mixed fluctuations
        assertFalse(solution.isMonotonic(new int[]{1, 2, 1, 2, 1}));
    }
}