package tree_traversal.maximum_depth_of_binary_tree;

import common.PrintHelper;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        return traversal(root, 0);
    }

    private int traversal(TreeNode root, int level) {
        if (Objects.isNull(root)) {
            return level;
        }

        return Math.max(
                traversal(root.left, level + 1),
                traversal(root.right, level + 1)
        );
    }


    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Tree {
        /**
         * Builds a binary tree from a level-order list.
         * null values represent missing nodes.
         */
        static TreeNode buildTree(Integer[] values) {
            if (values == null || values.length == 0) return null;
            if (values[0] == null) return null;

            TreeNode root = new TreeNode(values[0]);
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            int i = 1;
            while (!queue.isEmpty() && i < values.length) {
                TreeNode current = queue.poll();

                // Left child
                if (i < values.length && values[i] != null) {
                    current.left = new TreeNode(values[i]);
                    queue.add(current.left);
                }
                i++;

                // Right child
                if (i < values.length && values[i] != null) {
                    current.right = new TreeNode(values[i]);
                    queue.add(current.right);
                }
                i++;
            }

            return root;
        }
    }
}
