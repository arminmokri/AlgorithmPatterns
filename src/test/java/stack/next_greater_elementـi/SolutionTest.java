package stack.next_greater_elementـi;

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
        assertArrayEquals(
                new int[]{-1, 3, -1},
                solution.nextGreaterElement(
                        new int[]{4, 1, 2},
                        new int[]{1, 3, 4, 2}
                )
        );

        assertArrayEquals(
                new int[]{3, -1},
                solution.nextGreaterElement(
                        new int[]{2, 4},
                        new int[]{1, 2, 3, 4}
                )
        );
    }

    @Test
    public void testSingleElementPresentAndGreaterExists() {
        assertArrayEquals(
                new int[]{2},
                solution.nextGreaterElement(
                        new int[]{1},
                        new int[]{1, 2}
                )
        );
    }

    @Test
    public void testSingleElementNoGreaterExists() {
        assertArrayEquals(
                new int[]{-1},
                solution.nextGreaterElement(
                        new int[]{2},
                        new int[]{2, 1}
                )
        );
    }

    @Test
    public void testNums1EmptyReturnsEmpty() {
        assertArrayEquals(
                new int[]{},
                solution.nextGreaterElement(
                        new int[]{},
                        new int[]{1, 2, 3}
                )
        );
    }

    @Test
    public void testNums2SingleElementAllMinusOnes() {
        assertArrayEquals(
                new int[]{-1, -1},
                solution.nextGreaterElement(
                        new int[]{7, 7},  // assumes valid input in your environment; if nums1 must be subset of nums2, replace with valid values
                        new int[]{7}
                )
        );
    }

    @Test
    public void testStrictlyDecreasingNums2AllMinusOnes() {
        assertArrayEquals(
                new int[]{-1, -1, -1},
                solution.nextGreaterElement(
                        new int[]{5, 3, 1},
                        new int[]{5, 4, 3, 2, 1}
                )
        );
    }

    @Test
    public void testStrictlyIncreasingNums2AlwaysNextIsGreater() {
        assertArrayEquals(
                new int[]{4, 5, -1},
                solution.nextGreaterElement(
                        new int[]{3, 4, 5},
                        new int[]{1, 2, 3, 4, 5}
                )
        );
    }

    @Test
    public void testNegativeNumbersWorksCorrectly() {
        assertArrayEquals(
                new int[]{-2, 0, -1},
                solution.nextGreaterElement(
                        new int[]{-3, -1, 0},
                        new int[]{-3, -2, -1, 0}
                )
        );
    }

    @Test
    public void testMixedOrderWithSkips() {
        assertArrayEquals(
                new int[]{6, 7, 7, -1},
                solution.nextGreaterElement(
                        new int[]{2, 5, 6, 7},
                        new int[]{2, 6, 5, 7}
                )
        );
    }

    @Test
    public void testNextGreaterIsFarRightNotAdjacent() {
        assertArrayEquals(
                new int[]{7, 9, -1},
                solution.nextGreaterElement(
                        new int[]{1, 3, 9},
                        new int[]{1, 7, 3, 2, 9}
                )
        );
    }
}
