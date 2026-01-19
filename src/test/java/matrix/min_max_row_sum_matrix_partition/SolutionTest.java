package matrix.min_max_row_sum_matrix_partition;

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
                new int[]{4, 3},
                solution.minMaxRowSumMatrixPartition(new int[]{1, 1, 1, 20, 1, 1, 1, 1, 30, 5, 1, 1})
        );
    }

    @Test
    public void testAllOnes() {
        assertArrayEquals(
                new int[]{4, 2},
                solution.minMaxRowSumMatrixPartition(new int[]{1, 1, 1, 1, 1, 1, 1, 1})
        );
    }

    @Test
    public void testTwoPossibleShapes() {
        assertArrayEquals(
                new int[]{3, 2},
                solution.minMaxRowSumMatrixPartition(new int[]{10, 20, 30, 40, 50, 60})
        );
    }

    @Test
    public void testLargerValuesMiddle() {
        assertArrayEquals(
                new int[]{6, 2},
                solution.minMaxRowSumMatrixPartition(new int[]{1, 1, 100, 1, 1, 1, 100, 1, 1, 1, 100, 1})
        );
    }

    @Test
    public void testDecreasingSequence() {
        assertArrayEquals(
                new int[]{6, 2},
                solution.minMaxRowSumMatrixPartition(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
        );
    }

    @Test
    public void testIncreasingSequence() {
        assertArrayEquals(
                new int[]{6, 2},
                solution.minMaxRowSumMatrixPartition(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
        );
    }

    @Test
    public void testSymmetricalDistribution() {
        assertArrayEquals(
                new int[]{6, 2},
                solution.minMaxRowSumMatrixPartition(new int[]{1, 2, 3, 4, 100, 4, 3, 2, 1, 100, 1, 1})
        );
    }
}
