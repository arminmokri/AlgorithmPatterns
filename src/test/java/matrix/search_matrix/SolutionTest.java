package matrix.search_matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertTrue(solution.searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                },
                3
        ));

        assertFalse(solution.searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                },
                13
        ));
    }

    @Test
    public void testFirstElement() {
        assertTrue(solution.searchMatrix(
                new int[][]{
                        {1, 2},
                        {3, 4}
                },
                1
        ));
    }

    @Test
    public void testLastElement() {
        assertTrue(solution.searchMatrix(
                new int[][]{
                        {1, 2},
                        {3, 4}
                },
                4
        ));
    }

    @Test
    public void testSingleRowMatrix() {
        assertTrue(solution.searchMatrix(new int[][]{{1, 2, 3, 4}}, 3));
        assertFalse(solution.searchMatrix(new int[][]{{1, 2, 3, 4}}, 5));
    }

    @Test
    public void testSingleColumnMatrix() {
        assertTrue(solution.searchMatrix(
                new int[][]{
                        {1},
                        {2},
                        {3}
                },
                2
        ));
        assertFalse(solution.searchMatrix(
                new int[][]{
                        {1},
                        {2},
                        {3}
                },
                5
        ));
    }

    @Test
    public void testEmptyMatrix() {
        assertFalse(solution.searchMatrix(new int[][]{}, 1));
    }

    @Test
    public void testEmptyRows() {
        assertFalse(solution.searchMatrix(new int[][]{{}}, 1));
    }

    @Test
    public void testTargetNotInRange() {
        assertFalse(solution.searchMatrix(
                new int[][]{
                        {10, 20},
                        {30, 40}
                },
                5
        ));
        assertFalse(solution.searchMatrix(
                new int[][]{
                        {10, 20},
                        {30, 40}
                },
                50
        ));
    }

    @Test
    public void testDuplicateValues() {
        assertTrue(solution.searchMatrix(
                new int[][]{
                        {1, 1, 1},
                        {1, 1, 1}
                },
                1
        ));
    }
}
