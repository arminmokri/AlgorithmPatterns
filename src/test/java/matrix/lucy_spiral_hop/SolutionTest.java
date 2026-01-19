package matrix.lucy_spiral_hop;

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
        assertEquals(
                41,
                solution.lucySpiralHop(new int[][]{
                        {29, 8, 37},
                        {15, 41, 3},
                        {1, 10, 14}
                })
        );
    }

    @Test
    public void testSingleElement() {
        assertEquals(5, solution.lucySpiralHop(new int[][]{{5}}));
    }

    @Test
    public void testSingleRow() {
        assertEquals(5, solution.lucySpiralHop(new int[][]{{1, 2, 3, 4, 5}}));
    }

    @Test
    public void testSingleColumn() {
        assertEquals(3, solution.lucySpiralHop(new int[][]{
                {1},
                {2},
                {3},
                {4}
        }));
    }

    @Test
    public void testEvenSizedSquare() {
        assertEquals(3, solution.lucySpiralHop(new int[][]{
                {1, 2},
                {4, 3}
        }));
    }

    @Test
    public void testLargerMatrix() {
        assertEquals(
                15,
                solution.lucySpiralHop(new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7}
                })
        );
    }

    @Test
    public void testRectangularMatrix() {
        assertEquals(
                11,
                solution.lucySpiralHop(new int[][]{
                        {1, 2, 3},
                        {10, 11, 4},
                        {9, 12, 5},
                        {8, 7, 6}
                })
        );
    }
}
