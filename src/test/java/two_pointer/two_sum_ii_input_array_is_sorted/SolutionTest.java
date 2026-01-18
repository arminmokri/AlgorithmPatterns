package two_pointer.two_sum_ii_input_array_is_sorted;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertArrayEquals(
                new int[]{1, 2},
                solution.twoSum(new int[]{2, 7, 11, 15}, 9)
        );

        assertArrayEquals(
                new int[]{1, 3},
                solution.twoSum(new int[]{2, 3, 4}, 6)
        );

        assertArrayEquals(
                new int[]{1, 2},
                solution.twoSum(new int[]{-1, 0}, -1)
        );
    }

    @Test
    public void testTwoSum_MinimumInputSize() {
        assertArrayEquals(
                new int[]{1, 2},
                solution.twoSum(new int[]{1, 1}, 2)
        );
    }

    @Test
    public void testTwoSum_WithDuplicates() {
        assertArrayEquals(
                new int[]{1, 2},
                solution.twoSum(new int[]{3, 3, 4}, 6)
        );
    }

    @Test
    public void testTwoSum_TargetAtEnd() {
        assertArrayEquals(
                new int[]{2, 4},
                solution.twoSum(new int[]{1, 5, 7, 3}, 8)
        );
    }

    @Test
    public void testTwoSum_AllNegativeNumbers() {
        assertArrayEquals(
                new int[]{3, 4},
                solution.twoSum(new int[]{-8, -5, -3, -2}, -5)
        );
    }

    @Test
    public void testTwoSum_MixedPositiveAndNegative() {
        assertArrayEquals(
                new int[]{1, 4},
                solution.twoSum(new int[]{4, -2, 7, -1}, 3)
        );
    }

    @Test
    public void testTwoSum_LargeNumbers() {
        assertArrayEquals(
                new int[]{2, 3},
                solution.twoSum(new int[]{3, 1_000_000, 2_000_000}, 3_000_000)
        );
    }

    @Test
    public void testTwoSum_ResultUsesDifferentIndices() {
        int[] result = solution.twoSum(new int[]{0, 4, 3, 0}, 0);
        assertNotEquals(result[0], result[1]);
    }

    @Test
    public void testTwoSum_NoSolutionExists() {
        assertArrayEquals(
                new int[]{-1, -1},
                solution.twoSum(new int[]{1, 2, 3, 4}, 100)
        );
    }
}
