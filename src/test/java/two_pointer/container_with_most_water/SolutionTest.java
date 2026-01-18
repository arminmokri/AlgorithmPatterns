package two_pointer.container_with_most_water;

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
        assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(1, solution.maxArea(new int[]{1, 1}));
    }

    @Test
    public void testEmptyList() {
        assertEquals(0, solution.maxArea(new int[]{}));
    }

    @Test
    public void testSingleElement() {
        assertEquals(0, solution.maxArea(new int[]{5}));
    }

    @Test
    public void testAllSameHeight() {
        assertEquals(20, solution.maxArea(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    public void testMonotonicallyIncreasing() {
        assertEquals(6, solution.maxArea(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testMonotonicallyDecreasing() {
        assertEquals(6, solution.maxArea(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testPlateaus() {
        assertEquals(8, solution.maxArea(new int[]{2, 2, 2, 2, 2}));
    }

    @Test
    public void testValleys() {
        assertEquals(10, solution.maxArea(new int[]{5, 1, 5}));
    }

    @Test
    public void testHighPeaksEdges() {
        assertEquals(40, solution.maxArea(new int[]{10, 1, 1, 1, 10}));
    }

    @Test
    public void testLargeInput() {
        int[] heights = new int[10000];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 1;
        }
        assertEquals(9999, solution.maxArea(heights));
    }

    @Test
    public void testMiddlePeak() {
        assertEquals(
                100,
                solution.maxArea(new int[]{6, 3, 9, 7, 8, 5, 100, 100, 7, 8, 6, 5, 7, 8})
        );
    }
}
