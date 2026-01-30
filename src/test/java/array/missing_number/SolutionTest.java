package array.missing_number;


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
        assertEquals(2, solution.missingNumber(new int[]{3, 0, 1}));
        assertEquals(2, solution.missingNumber(new int[]{0, 1}));
        assertEquals(8, solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    @Test
    public void testSingleElementZero() {
        assertEquals(1, solution.missingNumber(new int[]{0}));
    }

    @Test
    public void testSingleElementOne() {
        assertEquals(0, solution.missingNumber(new int[]{1}));
    }

    @Test
    public void testMissingZero() {
        assertEquals(0, solution.missingNumber(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testMissingLastNumber() {
        assertEquals(4, solution.missingNumber(new int[]{0, 1, 2, 3}));
    }

    @Test
    public void testTwoElementsMissingMiddle() {
        assertEquals(1, solution.missingNumber(new int[]{0, 2}));
    }

    @Test
    public void testUnsortedInput() {
        assertEquals(3, solution.missingNumber(new int[]{4, 2, 1, 0}));
    }

    @Test
    public void testLargeSequentialInput() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i + 1; // missing 0
        }
        assertEquals(0, solution.missingNumber(nums));
    }

    @Test
    public void testLargeInputMissingMiddle() {
        int n = 1000;
        int missing = 567;
        int[] nums = new int[n];
        int idx = 0;

        for (int i = 0; i <= n; i++) {
            if (i != missing) {
                nums[idx++] = i;
            }
        }

        assertEquals(missing, solution.missingNumber(nums));
    }

    @Test
    public void testReverseOrderedInput() {
        assertEquals(2, solution.missingNumber(new int[]{4, 3, 1, 0}));
    }

}
