package two_pointer.move_zeroes;

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
        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums1);

        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        assertArrayEquals(new int[]{0}, nums2);
    }

    @Test
    public void testNoZeroes() {
        int[] nums = {1, 2, 3, 4, 5};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

    @Test
    public void testAllZeroes() {
        int[] nums = {0, 0, 0, 0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0}, nums);
    }

    @Test
    public void testZeroesAtEnd() {
        int[] nums = {1, 2, 3, 0, 0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, nums);
    }

    @Test
    public void testZeroesAtBeginning() {
        int[] nums = {0, 0, 1, 2, 3};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, nums);
    }

    @Test
    public void testAlternatingZeroes() {
        int[] nums = {0, 1, 0, 2, 0, 3};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0}, nums);
    }

    @Test
    public void testSingleElementNonZero() {
        int[] nums = {7};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{7}, nums);
    }

    @Test
    public void testLargeNumbers() {
        int[] nums = {100000, 0, -100000, 0, 5};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{100000, -100000, 5, 0, 0}, nums);
    }

    @Test
    public void testAlreadyStableOrder() {
        int[] nums = {4, 1, 2, 3, 0, 0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{4, 1, 2, 3, 0, 0}, nums);
    }

}
