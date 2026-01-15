package binary_search.binary_search;

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
        assertEquals(4, solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(-1, solution.search(new int[]{}, 1));
    }

    @Test
    public void testSingleElementFound() {
        assertEquals(0, solution.search(new int[]{5}, 5));
    }

    @Test
    public void testSingleElementNotFound() {
        assertEquals(-1, solution.search(new int[]{5}, 1));
    }

    @Test
    public void testTargetAtBeginning() {
        assertEquals(0, solution.search(new int[]{1, 3, 5, 7}, 1));
    }

    @Test
    public void testTargetAtEnd() {
        assertEquals(3, solution.search(new int[]{1, 3, 5, 7}, 7));
    }

    @Test
    public void testTargetInMiddle() {
        assertEquals(2, solution.search(new int[]{1, 3, 5, 7, 9}, 5));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(1, solution.search(new int[]{-10, -5, -2, 0, 3}, -5));
    }

    @Test
    public void testLargeArray() {
        int[] nums = new int[5000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 2; // even numbers from 0 to 9998
        }

        assertEquals(339, solution.search(nums, 678));
        assertEquals(-1, solution.search(nums, 9999));
    }
}
