package matrix.set_matrix_zeroes;

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

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);

        matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        expected = new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }


    @Test
    public void testSingleElementZero() {
        int[][] matrix = {{0}};
        int[][] expected = {{0}};

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSingleElementNonZero() {
        int[][] matrix = {{7}};
        int[][] expected = {{7}};

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testNoZerosMatrixUnchanged() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testAllZerosMatrixUnchanged() {
        int[][] matrix = {
                {0, 0},
                {0, 0}
        };
        int[][] expected = {
                {0, 0},
                {0, 0}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroInFirstRowOnly() {
        int[][] matrix = {
                {5, 0, 7},
                {1, 2, 3},
                {9, 8, 6}
        };
        int[][] expected = {
                {0, 0, 0},
                {1, 0, 3},
                {9, 0, 6}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroInFirstColumnOnly() {
        int[][] matrix = {
                {5, 7, 9},
                {0, 2, 3},
                {4, 8, 6}
        };
        int[][] expected = {
                {0, 7, 9},
                {0, 0, 0},
                {0, 8, 6}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testMultipleZerosDifferentRowsAndCols() {
        int[][] matrix = {
                {1, 2, 0, 4},
                {5, 6, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] expected = {
                {0, 0, 0, 0},
                {0, 6, 0, 8},
                {0, 0, 0, 0},
                {0, 14, 0, 16}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroAtIntersectionCreatesCascade() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 0}
        };
        int[][] expected = {
                {1, 0, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSingleRowWithZero() {
        int[][] matrix = {
                {1, 0, 3, 4}
        };
        int[][] expected = {
                {0, 0, 0, 0}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSingleColumnWithZero() {
        int[][] matrix = {
                {1},
                {0},
                {3}
        };
        int[][] expected = {
                {0},
                {0},
                {0}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRectangularMatrixWithZero() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 0, 9, 10}
        };
        int[][] expected = {
                {1, 2, 0, 4, 5},
                {0, 0, 0, 0, 0}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZerosAtCorners() {
        int[][] matrix = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 5, 0},
                {0, 0, 0}
        };

        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

}
