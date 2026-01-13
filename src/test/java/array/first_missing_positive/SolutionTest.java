package array.first_missing_positive;

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
        assertEquals(2, solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(6, solution.firstMissingPositive(new int[]{1, 2, 3, 4, 5, 10}));
        assertEquals(1, solution.firstMissingPositive(new int[]{-1, -3}));
    }

    @Test
    public void testAllPositiveConsecutive() {
        assertEquals(4, solution.firstMissingPositive(new int[]{1, 2, 3}));
    }

    @Test
    public void testMixedWithNegatives() {
        assertEquals(1, solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    public void testUnsortedWithGap() {
        assertEquals(3, solution.firstMissingPositive(new int[]{2, 1, 0}));
    }

    @Test
    public void testAllNegatives() {
        assertEquals(1, solution.firstMissingPositive(new int[]{-1, -2, -3}));
    }

    @Test
    public void testWithZero() {
        assertEquals(3, solution.firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
    }

    @Test
    public void testEmptyList() {
        assertEquals(1, solution.firstMissingPositive(new int[]{}));
    }

    @Test
    public void testLargeInputGapAtBeginning() {
        assertEquals(1, solution.firstMissingPositive(new int[]{10, 12, 11}));
    }
}