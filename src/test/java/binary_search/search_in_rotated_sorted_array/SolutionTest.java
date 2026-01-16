package binary_search.search_in_rotated_sorted_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, solution.search(new int[]{1}, 0));
    }

    @Test
    public void testSingleElementFound() {
        assertEquals(0, solution.search(new int[]{1}, 1));
    }

    @Test
    public void testTargetAtStart() {
        assertEquals(0, solution.search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 6));
    }

    @Test
    public void testTargetAtEnd() {
        assertEquals(7, solution.search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 5));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(-1, solution.search(new int[]{}, 3));
    }

    @Test
    public void testTargetNotInArray() {
        assertEquals(-1, solution.search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 8));
    }

    @Test
    public void testRotatedArrayDifferentPivot() {
        assertEquals(5, solution.search(new int[]{3, 4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(6, solution.search(new int[]{2, 3, 4, 5, 6, 7, 0, 1}, 0));
    }

    @Test
    public void testUnrotatedSortedArray() {
        assertEquals(4, solution.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 4));
        assertEquals(-1, solution.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 8));
    }

    @Test
    public void testDuplicatesInArray() {
        assertEquals(3, solution.search(new int[]{2, 2, 2, 3, 4, 2, 2}, 3));
    }
}
