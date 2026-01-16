package dfs_bfs.number_of_islands;

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
        assertEquals(1, solution.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        assertEquals(3, solution.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    @Test
    public void testSingleLandTile() {
        assertEquals(1, solution.numIslands(new char[][]{
                {'1'}
        }));
    }

    @Test
    public void testSingleWaterTile() {
        assertEquals(0, solution.numIslands(new char[][]{
                {'0'}
        }));
    }

    @Test
    public void testEmptyGrid() {
        assertEquals(0, solution.numIslands(new char[][]{
                {}
        }));
    }

    @Test
    public void testAllWater() {
        assertEquals(0, solution.numIslands(new char[][]{
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        }));
    }

    @Test
    public void testAllLand() {
        assertEquals(1, solution.numIslands(new char[][]{
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        }));
    }

    @Test
    public void testDiagonalIslands() {
        assertEquals(3, solution.numIslands(new char[][]{
                {'1', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        }));

        assertEquals(5, solution.numIslands(new char[][]{
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        }));
    }
}
