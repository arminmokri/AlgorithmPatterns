package dynamic_programming.longest_increasing_subsequence;

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
        assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(1, solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    @Test
    public void testEmptyList() {
        assertEquals(0, solution.lengthOfLIS(new int[]{}));
    }

    @Test
    public void testSingleElement() {
        assertEquals(1, solution.lengthOfLIS(new int[]{42}));
    }

    @Test
    public void testStrictlyIncreasing() {
        assertEquals(6, solution.lengthOfLIS(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testStrictlyDecreasing() {
        assertEquals(1, solution.lengthOfLIS(new int[]{6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void testAlternatingUpDown() {
        assertEquals(4, solution.lengthOfLIS(new int[]{1, 3, 2, 4, 3, 5}));
    }

    @Test
    public void testDuplicateElements() {
        assertEquals(3, solution.lengthOfLIS(new int[]{1, 2, 2, 2, 3}));
    }

    @Test
    public void testAllSameExceptOne() {
        assertEquals(2, solution.lengthOfLIS(new int[]{2, 2, 2, 2, 3}));
    }

    @Test
    public void testLargeInput() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i;
        }
        assertEquals(1000, solution.lengthOfLIS(nums));
    }

    @Test
    public void testZigzagPattern() {
        assertEquals(4, solution.lengthOfLIS(new int[]{3, 1, 2, 1, 5, 4, 6}));
    }
}
