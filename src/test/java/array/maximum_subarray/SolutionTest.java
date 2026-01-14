package array.maximum_subarray;


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
        assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, solution.maxSubArray(new int[]{1}));
        assertEquals(23, solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    @Test
    public void testAllNegative() {
        assertEquals(-1, solution.maxSubArray(new int[]{-1, -2, -3, -4}));
    }

    @Test
    public void testAllPositive() {
        assertEquals(15, solution.maxSubArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testSingleElement() {
        assertEquals(-100, solution.maxSubArray(new int[]{-100}));
        assertEquals(0, solution.maxSubArray(new int[]{0}));
        assertEquals(100, solution.maxSubArray(new int[]{100}));
    }

    @Test
    public void testMixedWithZeroes() {
        assertEquals(0, solution.maxSubArray(new int[]{-2, 0, -1}));
    }

    @Test
    public void testLargeInput() {
        int[] nums = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1;
        }
        assertEquals(10000, solution.maxSubArray(nums));
    }

    @Test
    public void testMaxAtEnd() {
        assertEquals(11, solution.maxSubArray(new int[]{-3, -2, 5, 6}));
    }

    @Test
    public void testMaxAtStart() {
        assertEquals(10, solution.maxSubArray(new int[]{10, -1, -2, -3}));
    }

    @Test
    public void testMaxInMiddle() {
        assertEquals(6, solution.maxSubArray(new int[]{-5, 4, -1, 2, 1, -5}));
    }

    @Test
    public void testMultipleSameMaxSubarrays() {
        assertEquals(1, solution.maxSubArray(new int[]{1, -1, 1, -1, 1}));
    }
}
