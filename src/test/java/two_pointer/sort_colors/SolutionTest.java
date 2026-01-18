package two_pointer.sort_colors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums1);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums1);

        int[] nums2 = {2, 0, 1};
        solution.sortColors(nums2);
        assertArrayEquals(new int[]{0, 1, 2}, nums2);
    }

    @Test
    public void testAllZeros() {
        int[] nums = {0, 0, 0, 0};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0}, nums);
    }

    @Test
    public void testAllOnes() {
        int[] nums = {1, 1, 1, 1};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{1, 1, 1, 1}, nums);
    }

    @Test
    public void testAllTwos() {
        int[] nums = {2, 2, 2};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{2, 2, 2}, nums);
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    public void testMixedSortedInput() {
        int[] nums = {0, 1, 2, 0, 1, 2};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testAlreadySorted() {
        int[] nums = {0, 0, 1, 1, 2, 2};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testReverseSorted() {
        int[] nums = {2, 2, 1, 1, 0, 0};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }
}
