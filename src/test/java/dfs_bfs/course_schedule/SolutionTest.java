package dfs_bfs.course_schedule;


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
        assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
        assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }


    @Test
    public void testNoPrerequisites_AllCoursesFinishable() {
        assertTrue(solution.canFinish(5, new int[][]{}));
        assertTrue(solution.canFinish(1, new int[][]{}));
        assertTrue(solution.canFinish(0, new int[][]{})); // if your implementation supports 0 courses
    }

    @Test
    public void testLinearChain_Finishable() {
        // 0 -> 1 -> 2 -> 3
        assertTrue(solution.canFinish(4, new int[][]{
                {1, 0},
                {2, 1},
                {3, 2}
        }));
    }

    @Test
    public void testStarDependencies_Finishable() {
        // All require 0
        assertTrue(solution.canFinish(6, new int[][]{
                {1, 0},
                {2, 0},
                {3, 0},
                {4, 0},
                {5, 0}
        }));
    }

    @Test
    public void testDisconnectedGraph_Finishable() {
        // Component A: 0 -> 1, Component B: 2 -> 3
        assertTrue(solution.canFinish(4, new int[][]{
                {1, 0},
                {3, 2}
        }));
    }

    @Test
    public void testDisconnectedGraph_WithCycle_NotFinishable() {
        // Component A has a cycle: 0 <-> 1, Component B is fine: 2 -> 3
        assertFalse(solution.canFinish(4, new int[][]{
                {1, 0},
                {0, 1},
                {3, 2}
        }));
    }

    @Test
    public void testSelfDependency_NotFinishable() {
        // Course depends on itself
        assertFalse(solution.canFinish(1, new int[][]{
                {0, 0}
        }));
    }

    @Test
    public void testSmallCycle_LengthThree_NotFinishable() {
        // 0 -> 1 -> 2 -> 0
        assertFalse(solution.canFinish(3, new int[][]{
                {1, 0},
                {2, 1},
                {0, 2}
        }));
    }

    @Test
    public void testDiamondShape_Finishable() {
        // 0 -> 1, 0 -> 2, then 1 -> 3 and 2 -> 3 (no cycle)
        assertTrue(solution.canFinish(4, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        }));
    }

    @Test
    public void testDuplicateEdges_Finishable() {
        // Duplicate prerequisites shouldn't change the outcome
        assertTrue(solution.canFinish(2, new int[][]{
                {1, 0},
                {1, 0}
        }));
    }

    @Test
    public void testManyCourses_SparseEdges_Finishable() {
        assertTrue(solution.canFinish(10, new int[][]{
                {5, 1},
                {6, 2},
                {7, 3},
                {8, 4}
        }));
    }

}
