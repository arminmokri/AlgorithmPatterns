package array.majority_element;

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
        assertEquals(3, solution.majorityElement(new int[]{3, 2, 3}));
        assertEquals(2, solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    public void testSingleElementArray() {
        assertEquals(1, solution.majorityElement(new int[]{1}));
    }

    @Test
    public void testAllElementsSame() {
        assertEquals(5, solution.majorityElement(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    public void testMajorityAtBeginning() {
        assertEquals(4, solution.majorityElement(new int[]{4, 4, 4, 2, 3}));
    }

    @Test
    public void testMajorityAtEnd() {
        assertEquals(7, solution.majorityElement(new int[]{1, 2, 7, 7, 7}));
    }

    @Test
    public void testMajorityWithNegativeNumbers() {
        assertEquals(-1, solution.majorityElement(new int[]{-1, -1, -1, 2, 3}));
    }

    @Test
    public void testMajorityWithMixedPositiveAndNegative() {
        assertEquals(0, solution.majorityElement(new int[]{0, -1, 0, 0, 2, 0, 0}));
    }

    @Test
    public void testLargeArrayMajority() {
        int[] nums = new int[1001];
        for (int i = 0; i < 600; i++) nums[i] = 9;
        for (int i = 600; i < nums.length; i++) nums[i] = 1;

        assertEquals(9, solution.majorityElement(nums));
    }

    @Test
    public void testMajorityBarelyOverHalf() {
        assertEquals(8, solution.majorityElement(new int[]{8, 8, 1, 2, 8}));
    }

}
