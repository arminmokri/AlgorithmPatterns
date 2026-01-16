package dfs_bfs.clone_graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    private boolean compareGraphs(Solution.Node node1, Solution.Node node2, Set<Solution.Node> visited) {
        if (node1 == node2) return false; // Must be a deep copy

        if (node1 == null || node2 == null) return node1 == node2;

        if (node1.val != node2.val) return false;

        if (visited.contains(node1)) return true;

        visited.add(node1);

        if (node1.neighbors.size() != node2.neighbors.size()) return false;

        boolean flag = true;
        for (int i = 0; i < node1.neighbors.size(); i++) {
            Solution.Node n1 = node1.neighbors.get(i);
            Solution.Node n2 = node2.neighbors.get(i);
            if (!compareGraphs(n1, n2, visited)) {
                System.out.println(
                        "Node with value " + n1.val
                                + " was not copied but a reference to the original one. same memory address "
                                + System.identityHashCode(n1) + " = " + System.identityHashCode(n2)
                );
                flag = false;
            }
        }
        return flag;
    }

    private boolean compareGraphs(Solution.Node node1, Solution.Node node2) {
        return compareGraphs(node1, node2, new HashSet<>());
    }

    @Test
    public void testDefaultCase() {
        int[][] inputAdj1 = new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Solution.Node inputGraph1 = Solution.Graph.build(inputAdj1);
        Solution.Node clonedGraph1 = solution.cloneGraph(inputGraph1);
        List<List<Integer>> outputAdj1 = Solution.Graph.toAdjList(clonedGraph1);
        assertEquals(Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(1, 3)
        ), outputAdj1);
        assertTrue(compareGraphs(inputGraph1, clonedGraph1, new HashSet<>()));

        int[][] inputAdj2 = new int[][]{{}};
        Solution.Node inputGraph2 = Solution.Graph.build(inputAdj2);
        Solution.Node clonedGraph2 = solution.cloneGraph(inputGraph2);
        List<List<Integer>> outputAdj2 = Solution.Graph.toAdjList(clonedGraph2);
        assertEquals(Arrays.asList(Collections.emptyList()), outputAdj2);
        assertTrue(compareGraphs(inputGraph2, clonedGraph2, new HashSet<>()));

        assertNull(solution.cloneGraph(null));
    }

    @Test
    public void testSquareGraph() {
        int[][] inputAdj = new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Solution.Node inputGraph = Solution.Graph.build(inputAdj);
        Solution.Node clonedGraph = solution.cloneGraph(inputGraph);
        List<List<Integer>> outputAdj = Solution.Graph.toAdjList(clonedGraph);

        assertEquals(Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(1, 3)
        ), outputAdj);
        assertTrue(compareGraphs(inputGraph, clonedGraph));
    }

    @Test
    public void testSingleNode() {
        int[][] inputAdj = new int[][]{{}};
        Solution.Node inputGraph = Solution.Graph.build(inputAdj);
        Solution.Node clonedGraph = solution.cloneGraph(inputGraph);
        List<List<Integer>> outputAdj = Solution.Graph.toAdjList(clonedGraph);

        assertEquals(Arrays.asList(Collections.emptyList()), outputAdj);
        assertTrue(compareGraphs(inputGraph, clonedGraph));
    }

    @Test
    public void testNoneInput() {
        assertNull(solution.cloneGraph(null));
    }

    @Test
    public void testTwoConnectedNodes() {
        int[][] inputAdj = new int[][]{{2}, {1}};
        Solution.Node inputGraph = Solution.Graph.build(inputAdj);
        Solution.Node clonedGraph = solution.cloneGraph(inputGraph);
        List<List<Integer>> outputAdj = Solution.Graph.toAdjList(clonedGraph);

        assertEquals(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(1)
        ), outputAdj);
        assertTrue(compareGraphs(inputGraph, clonedGraph));
    }

    @Test
    public void testFullyConnectedGraph() {
        int[][] inputAdj = new int[][]{{2, 3, 4}, {1, 3, 4}, {1, 2, 4}, {1, 2, 3}};
        Solution.Node inputGraph = Solution.Graph.build(inputAdj);
        Solution.Node clonedGraph = solution.cloneGraph(inputGraph);
        List<List<Integer>> outputAdj = Solution.Graph.toAdjList(clonedGraph);

        assertEquals(Arrays.asList(
                Arrays.asList(2, 3, 4),
                Arrays.asList(1, 3, 4),
                Arrays.asList(1, 2, 4),
                Arrays.asList(1, 2, 3)
        ), outputAdj);
        assertTrue(compareGraphs(inputGraph, clonedGraph));
    }
}
