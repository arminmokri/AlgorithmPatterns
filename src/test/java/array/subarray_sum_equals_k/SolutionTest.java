package array.subarray_sum_equals_k;


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
        assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, solution.subarraySum(new int[]{1, 2, 3}, 3));
    }


    @Test
    public void testSingleElementEqualsK() {
        assertEquals(1, solution.subarraySum(new int[]{3}, 3));
    }

    @Test
    public void testSingleElementNotEqualsK() {
        assertEquals(0, solution.subarraySum(new int[]{3}, 2));
    }

    @Test
    public void testAllZerosKZero() {
        // n*(n+1)/2 subarrays sum to 0 when all elements are 0
        assertEquals(10, solution.subarraySum(new int[]{0, 0, 0, 0}, 0));
    }

    @Test
    public void testAllZerosKNonZero() {
        assertEquals(0, solution.subarraySum(new int[]{0, 0, 0, 0}, 2));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(3, solution.subarraySum(new int[]{1, -1, 0}, 0)); // [1,-1], [0], [1,-1,0]
    }

    @Test
    public void testMixedPositiveNegativeMultipleMatches() {
        assertEquals(4, solution.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }

    @Test
    public void testKIsNegative() {
        assertEquals(1, solution.subarraySum(new int[]{-1, -1, 1}, -2)); // [-1,-1]
    }

    @Test
    public void testNoSubarrayMatches() {
        assertEquals(0, solution.subarraySum(new int[]{2, 4, 6}, 5));
    }

    @Test
    public void testLargeKComparedToSum() {
        assertEquals(0, solution.subarraySum(new int[]{1, 2, 3, 4}, 100));
    }
}
