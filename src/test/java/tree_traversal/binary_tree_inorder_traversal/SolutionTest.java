package tree_traversal.binary_tree_inorder_traversal;

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
        Solution.TreeNode root1 = Solution.Tree.buildTree(new Integer[]{1, null, 2, 3});
        assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root1));

        // Input: [1,2,3,4,5,null,8,null,null,6,7,9]
        // Tree:             1
        //                 /   \
        //               2       3
        //              / \       \
        //             4   5       8
        //                / \     /
        //               6   7   9
        Solution.TreeNode root2 = Solution.Tree.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9});
        assertEquals(Arrays.asList(4, 2, 6, 5, 7, 1, 3, 9, 8), solution.inorderTraversal(root2));

        // Input: []
        // Tree: empty
        Solution.TreeNode root3 = Solution.Tree.buildTree(new Integer[]{});
        assertEquals(Collections.emptyList(), solution.inorderTraversal(root3));

        // Input: [1]
        // Tree: 1
        Solution.TreeNode root4 = Solution.Tree.buildTree(new Integer[]{1});
        assertEquals(Arrays.asList(1), solution.inorderTraversal(root4));
    }

    @Test
    public void testEmptyTree() {
        Solution.TreeNode root = Solution.Tree.buildTree(new Integer[]{});
        assertEquals(Collections.emptyList(), solution.inorderTraversal(root));
    }

    @Test
    public void testSingleNode() {
        Solution.TreeNode root = Solution.Tree.buildTree(new Integer[]{1});
        assertEquals(Arrays.asList(1), solution.inorderTraversal(root));
    }

    @Test
    public void testRightSkewedTree() {
        // Tree:     1
        //            \
        //             2
        //              \
        //               3
        Solution.TreeNode root = Solution.Tree.buildTree(new Integer[]{1, null, 2, null, 3});
        assertEquals(Arrays.asList(1, 2, 3), solution.inorderTraversal(root));
    }

    @Test
    public void testLeftSkewedTree() {
        // Tree:         3
        //              /
        //            2
        //           /
        //         1
        Solution.TreeNode root = Solution.Tree.buildTree(new Integer[]{3, 2, null, 1});
        assertEquals(Arrays.asList(1, 2, 3), solution.inorderTraversal(root));
    }

    @Test
    public void testBalancedTree() {
        // Tree:      1
        //           / \
        //          2   3
        Solution.TreeNode root = Solution.Tree.buildTree(new Integer[]{1, 2, 3});
        assertEquals(Arrays.asList(2, 1, 3), solution.inorderTraversal(root));
    }
}
