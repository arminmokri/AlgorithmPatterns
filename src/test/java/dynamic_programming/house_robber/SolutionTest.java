package dynamic_programming.house_robber;

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
        assertEquals(4, solution.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    public void testEdgeCaseEmpty() {
        assertEquals(0, solution.rob(new int[]{}));
    }

    @Test
    public void testEdgeCaseSingleElement() {
        assertEquals(9, solution.rob(new int[]{9}));
    }

    @Test
    public void testEdgeCaseTwoElements() {
        assertEquals(10, solution.rob(new int[]{4, 10}));
        assertEquals(15, solution.rob(new int[]{15, 1}));
    }

    @Test
    public void testAlternatingHighLow() {
        assertEquals(30, solution.rob(new int[]{10, 1, 10, 1, 10}));
    }

    @Test
    public void testAllSameValues() {
        assertEquals(15, solution.rob(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    public void testLargeInput() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1; // 1..100
        }
        assertEquals(2550, solution.rob(nums));
    }
}
