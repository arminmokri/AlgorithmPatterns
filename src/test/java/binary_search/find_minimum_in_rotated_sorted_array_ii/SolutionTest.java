package binary_search.find_minimum_in_rotated_sorted_array_ii;

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
        assertEquals(1, solution.findMin(new int[]{1, 3, 5}));
        assertEquals(0, solution.findMin(new int[]{2, 2, 2, 0, 1}));
    }

    @Test
    public void testSingleElement() {
        assertEquals(42, solution.findMin(new int[]{42}));
    }

    @Test
    public void testTwoElementsRotated() {
        assertEquals(1, solution.findMin(new int[]{2, 1}));
    }

    @Test
    public void testTwoElementsNotRotated() {
        assertEquals(1, solution.findMin(new int[]{1, 2}));
    }

    @Test
    public void testRepeatedElements() {
        assertEquals(0, solution.findMin(new int[]{2, 2, 2, 0, 1, 2}));
    }

    @Test
    public void testMinimumAtEnd() {
        assertEquals(1, solution.findMin(new int[]{2, 3, 4, 5, 1}));
    }

    @Test
    public void testMinimumAtStart() {
        assertEquals(0, solution.findMin(new int[]{0, 1, 2, 3, 4}));
    }

    @Test
    public void testAllEqualElements() {
        assertEquals(5, solution.findMin(new int[]{5, 5, 5, 5}));
    }
}
