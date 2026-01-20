package sliding_window.maximum_average_subarray_i;

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
        assertEquals(12.75, solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 1e-9);
        assertEquals(5.0, solution.findMaxAverage(new int[]{5}, 1), 1e-9);
    }

    @Test
    public void testAllPositive() {
        assertEquals(4.5, solution.findMaxAverage(new int[]{1, 2, 3, 4, 5}, 2), 1e-9);
    }

    @Test
    public void testAllNegative() {
        assertEquals(-1.5, solution.findMaxAverage(new int[]{-1, -2, -3, -4}, 2), 1e-9);
    }

    @Test
    public void testSingleElementWindow() {
        assertEquals(5.0, solution.findMaxAverage(new int[]{5, 1, -2, 3}, 1), 1e-9);
    }

    @Test
    public void testFullArrayWindow() {
        assertEquals(5.0, solution.findMaxAverage(new int[]{2, 4, 6, 8}, 4), 1e-9);
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(1_000_000.0, solution.findMaxAverage(new int[]{1_000_000, 1_000_000, 1_000_000}, 2), 1e-9);
    }
}
