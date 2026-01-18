package tree_traversal.binary_tree_postorder_traversal;

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
        // Input: [1, null, 2, 3]
        // Tree:         1
        //                \
        //                 2
        //                /
        //               3
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{1, null, 2, 3});

        assertEquals(
                Arrays.asList(3, 2, 1),
                solution.postorderTraversal(root)
        );

        // Input: [1,2,3,4,5,null,8,null,null,6,7,9]
        // Tree:             1
        //                 /   \
        //               2       3
        //              / \       \
        //             4   5       8
        //                / \     /
        //               6   7   9
        root = Solution.Tree.buildTree(
                new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9}
        );

        assertEquals(
                Arrays.asList(4, 6, 7, 5, 2, 9, 8, 3, 1),
                solution.postorderTraversal(root)
        );

        // Input: []
        // Tree: empty
        root = Solution.Tree.buildTree(new Integer[]{});
        assertEquals(Collections.emptyList(), solution.postorderTraversal(root));

        // Input: [1]
        // Tree: 1
        root = Solution.Tree.buildTree(new Integer[]{1});
        assertEquals(Arrays.asList(1), solution.postorderTraversal(root));
    }

    @Test
    public void testEmptyTree() {
        // Tree: empty
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{});

        assertEquals(Collections.emptyList(), solution.postorderTraversal(root));
    }

    @Test
    public void testSingleNode() {
        // Tree: 1
        Solution.TreeNode root =
                Solution.Tree.buildTree(new Integer[]{1});

        assertEquals(Arrays.asList(1), solution.postorderTraversal(root));
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
                Arrays.asList(3, 2, 1),
                solution.postorderTraversal(root)
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
                Arrays.asList(1, 2, 3),
                solution.postorderTraversal(root)
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
                Arrays.asList(2, 3, 1),
                solution.postorderTraversal(root)
        );
    }
}
