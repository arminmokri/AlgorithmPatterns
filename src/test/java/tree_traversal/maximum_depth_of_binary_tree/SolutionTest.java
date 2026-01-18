package tree_traversal.maximum_depth_of_binary_tree;

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
        // Input: [3,9,20,null,null,15,7]
        // Tree:
        //         3
        //        / \
        //       9  20
        //          / \
        //         15  7
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        assertEquals(3, solution.maxDepth(root));

        // Input: [1,null,2]
        // Tree:
        //    1
        //     \
        //      2
        root = Solution.Tree.buildTree(new Integer[]{1, null, 2});
        assertEquals(2, solution.maxDepth(root));
    }

    @Test
    public void testEmptyTree() {
        // Tree: empty
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{});

        assertEquals(0, solution.maxDepth(root));
    }

    @Test
    public void testSingleNode() {
        // Tree: 1
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{1});

        assertEquals(1, solution.maxDepth(root));
    }

    @Test
    public void testRightSkewedTree() {
        // Tree:     1
        //            \
        //             2
        //              \
        //               3
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{1, null, 2, null, 3});

        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    public void testLeftSkewedTree() {
        // Tree:         3
        //              /
        //            2
        //           /
        //         1
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{3, 2, null, 1});

        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    public void testBalancedTree() {
        // Tree:      1
        //           / \
        //          2   3
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{1, 2, 3});

        assertEquals(2, solution.maxDepth(root));
    }
}
