package matrix.spiral_matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertEquals(
                Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5),
                solution.spiralOrder(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                })
        );

        assertEquals(
                Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                solution.spiralOrder(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                })
        );
    }

    @Test
    public void testSingleElement() {
        assertEquals(
                Collections.singletonList(5),
                solution.spiralOrder(new int[][]{{5}})
        );
    }

    @Test
    public void testSingleRow() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4),
                solution.spiralOrder(new int[][]{{1, 2, 3, 4}})
        );
    }

    @Test
    public void testSingleColumn() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4),
                solution.spiralOrder(new int[][]{
                        {1},
                        {2},
                        {3},
                        {4}
                })
        );
    }

    @Test
    public void testTwoByTwo() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4),
                solution.spiralOrder(new int[][]{
                        {1, 2},
                        {4, 3}
                })
        );
    }

    @Test
    public void testEmptyMatrix() {
        assertEquals(
                Collections.emptyList(),
                solution.spiralOrder(new int[][]{})
        );
    }

    @Test
    public void testMatrixWithOneEmptyRow() {
        assertEquals(
                Collections.emptyList(),
                solution.spiralOrder(new int[][]{{}})
        );
    }
}
