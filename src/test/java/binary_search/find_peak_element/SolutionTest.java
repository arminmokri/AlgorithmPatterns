package binary_search.find_peak_element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3, 1}));

        int actualValue = solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        assertTrue(
                actualValue == 2
                        || actualValue == 5
        );
    }


    @Test
    public void testSingleElement_ReturnsZero() {
        assertEquals(0, solution.findPeakElement(new int[]{7}));
    }

    @Test
    public void testTwoElements_Increasing_ReturnsLastIndex() {
        assertEquals(1, solution.findPeakElement(new int[]{1, 2}));
    }

    @Test
    public void testTwoElements_Decreasing_ReturnsFirstIndex() {
        assertEquals(0, solution.findPeakElement(new int[]{2, 1}));
    }

    @Test
    public void testStrictlyIncreasing_ReturnsLastIndex() {
        assertEquals(4, solution.findPeakElement(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testStrictlyDecreasing_ReturnsFirstIndex() {
        assertEquals(0, solution.findPeakElement(new int[]{9, 7, 5, 3, 1}));
    }

    @Test
    public void testPeakInMiddle_ReturnsPeakIndex() {
        // peak at index 2 (value 10)
        assertEquals(2, solution.findPeakElement(new int[]{1, 3, 10, 4, 2}));
    }

    @Test
    public void testMultiplePeaks_ResultIsAnyValidPeak() {
        int[] nums = {1, 3, 2, 4, 1}; // peaks at index 1 and 3
        int idx = solution.findPeakElement(nums);

        assertTrue(isPeak(nums, idx), "Returned index is not a valid peak: " + idx);
    }

    @Test
    public void testValleyBetweenTwoPeaks_ResultIsPeak() {
        int[] nums = {5, 1, 5}; // peaks at index 0 and 2 (both > neighbor)
        int idx = solution.findPeakElement(nums);

        assertTrue(isPeak(nums, idx), "Returned index is not a valid peak: " + idx);
    }

    @Test
    public void testLargeValues_NoOverflowIssues_ResultIsPeak() {
        int[] nums = {Integer.MIN_VALUE, -1, Integer.MAX_VALUE};
        assertEquals(2, solution.findPeakElement(nums)); // last is peak
    }

    // Helper: validates the LeetCode "peak element" definition (strictly greater than neighbors),
    // treating out-of-bounds neighbors as -infinity.
    private boolean isPeak(int[] nums, int i) {
        if (i < 0 || i >= nums.length) return false;
        int left = (i == 0) ? Integer.MIN_VALUE : nums[i - 1];
        int right = (i == nums.length - 1) ? Integer.MIN_VALUE : nums[i + 1];
        return nums[i] > left && nums[i] > right;
    }

}
