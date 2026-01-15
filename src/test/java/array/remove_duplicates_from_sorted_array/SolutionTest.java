package array.remove_duplicates_from_sorted_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        int[] nums = {1, 1, 2};
        int k = solution.removeDuplicates(nums);
        assertEquals(2, k);
        assertArrayEquals(new int[]{1, 2}, copyPrefix(nums, k));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = solution.removeDuplicates(nums);
        assertEquals(5, k);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, copyPrefix(nums, k));
    }

    @Test
    public void testEmptyList() {
        int[] nums = {};
        int k = solution.removeDuplicates(nums);
        assertEquals(0, k);
        assertArrayEquals(new int[]{}, copyPrefix(nums, k));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {42};
        int k = solution.removeDuplicates(nums);
        assertEquals(1, k);
        assertArrayEquals(new int[]{42}, copyPrefix(nums, k));
    }

    @Test
    public void testAllUnique() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = solution.removeDuplicates(nums);
        assertEquals(5, k);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, copyPrefix(nums, k));
    }

    @Test
    public void testAllDuplicates() {
        int[] nums = {9, 9, 9, 9};
        int k = solution.removeDuplicates(nums);
        assertEquals(1, k);
        assertArrayEquals(new int[]{9}, copyPrefix(nums, k));
    }

    @Test
    public void testTwoDuplicatesInMiddle() {
        int[] nums = {1, 2, 2, 3, 4};
        int k = solution.removeDuplicates(nums);
        assertEquals(4, k);
        assertArrayEquals(new int[]{1, 2, 3, 4}, copyPrefix(nums, k));
    }

    private int[] copyPrefix(int[] nums, int k) {
        int[] result = new int[k];
        System.arraycopy(nums, 0, result, 0, k);
        return result;
    }
}
