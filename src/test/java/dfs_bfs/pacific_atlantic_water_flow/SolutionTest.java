package dfs_bfs.pacific_atlantic_water_flow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
                List.of(
                        List.of(0, 4),
                        List.of(1, 3),
                        List.of(1, 4),
                        List.of(2, 2),
                        List.of(3, 0),
                        List.of(3, 1),
                        List.of(4, 0)
                ),
                solution.pacificAtlantic(new int[][]{
                        {1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4}
                }));

        assertEquals(
                List.of(
                        List.of(0, 0)
                ),
                solution.pacificAtlantic(new int[][]{
                        {1}
                }));
    }


    @Test
    public void testSingleRowIncreasing() {
        // In a 1xN grid, every cell touches both oceans via the shared top/bottom edge.
        assertEquals(
                List.of(
                        List.of(0, 0),
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(0, 3)
                ),
                solution.pacificAtlantic(new int[][]{
                        {1, 2, 3, 4}
                })
        );
    }

    @Test
    public void testSingleColumnDecreasing() {
        // In an Mx1 grid, every cell touches both oceans via the shared left/right edge.
        assertEquals(
                List.of(
                        List.of(0, 0),
                        List.of(1, 0),
                        List.of(2, 0),
                        List.of(3, 0)
                ),
                solution.pacificAtlantic(new int[][]{
                        {4},
                        {3},
                        {2},
                        {1}
                })
        );
    }

    @Test
    public void testAllEqualHeights() {
        // Every cell can reach both oceans because you can move across equal heights everywhere.
        assertEquals(
                List.of(
                        List.of(0, 0), List.of(0, 1), List.of(0, 2),
                        List.of(1, 0), List.of(1, 1), List.of(1, 2),
                        List.of(2, 0), List.of(2, 1), List.of(2, 2)
                ),
                solution.pacificAtlantic(new int[][]{
                        {7, 7, 7},
                        {7, 7, 7},
                        {7, 7, 7}
                })
        );
    }

    @Test
    public void testStrictlyIncreasingToBottomRight() {
        // Only cells on bottom row or right column can reach Atlantic,
        // but all cells can reach Pacific. Intersection => bottom row + right column.
        assertEquals(
                List.of(
                        List.of(0, 2),
                        List.of(1, 2),
                        List.of(2, 0),
                        List.of(2, 1),
                        List.of(2, 2)
                ),
                solution.pacificAtlantic(new int[][]{
                        {1, 2, 3},
                        {2, 3, 4},
                        {3, 4, 5}
                })
        );
    }

    @Test
    public void testStrictlyDecreasingToBottomRight() {
        // All cells can reach Atlantic (flow down to bottom/right),
        // but only top row or left column can reach Pacific. Intersection => top row + left column.
        assertEquals(
                List.of(
                        List.of(0, 0),
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(1, 0),
                        List.of(2, 0)
                ),
                solution.pacificAtlantic(new int[][]{
                        {9, 8, 7},
                        {8, 7, 6},
                        {7, 6, 5}
                })
        );
    }

    @Test
    public void testCenterPeak() {
        // Center is highest, so it can flow to all directions -> reaches both oceans.
        // Edges are on an ocean already; corners obviously reach both via edges.
        assertEquals(
                List.of(
                        List.of(0, 0), List.of(0, 1), List.of(0, 2),
                        List.of(1, 0), List.of(1, 1), List.of(1, 2),
                        List.of(2, 0), List.of(2, 1), List.of(2, 2)
                ),
                solution.pacificAtlantic(new int[][]{
                        {1, 1, 1},
                        {1, 9, 1},
                        {1, 1, 1}
                })
        );
    }
}
