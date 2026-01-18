package tree_traversal.binary_tree_level_order_traversal;

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
        // Input: [3,9,20,null,null,15,7]
        // Tree:
        //         3
        //        / \
        //       9  20
        //          / \
        //         15  7
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        assertEquals(
                Arrays.asList(
                        Arrays.asList(3),
                        Arrays.asList(9, 20),
                        Arrays.asList(15, 7)
                ),
                solution.levelOrder(root)
        );

        // Input: [1]
        // Tree: 1
        root = Solution.Tree.buildTree(new Integer[]{1});
        assertEquals(
                Arrays.asList(Arrays.asList(1)),
                solution.levelOrder(root)
        );

        // Input: []
        // Tree: empty
        root = Solution.Tree.buildTree(new Integer[]{});
        assertEquals(
                Collections.emptyList(),
                solution.levelOrder(root)
        );
    }

    @Test
    public void testEmptyTree() {
        // Tree: empty
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{});

        assertEquals(Collections.emptyList(), solution.levelOrder(root));
    }

    @Test
    public void testSingleNode() {
        // Tree: 1
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{1});

        assertEquals(
                Arrays.asList(Arrays.asList(1)),
                solution.levelOrder(root)
        );
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

        assertEquals(
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(2),
                        Arrays.asList(3)
                ),
                solution.levelOrder(root)
        );
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

        assertEquals(
                Arrays.asList(
                        Arrays.asList(3),
                        Arrays.asList(2),
                        Arrays.asList(1)
                ),
                solution.levelOrder(root)
        );
    }

    @Test
    public void testBalancedTree() {
        // Tree:      1
        //           / \
        //          2   3
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{1, 2, 3});

        assertEquals(
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(2, 3)
                ),
                solution.levelOrder(root)
        );
    }
}
