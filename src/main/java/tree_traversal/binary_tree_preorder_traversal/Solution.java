package tree_traversal.binary_tree_preorder_traversal;

import common.PrintHelper;

import java.util.*;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        List<Integer> order = new ArrayList<>();
        traversal(root, order);
        return order;
    }

    private void traversal(TreeNode root, List<Integer> order) {
        if (Objects.isNull(root)) {
            return;
        }

        order.add(root.val);
        traversal(root.left, order);
        traversal(root.right, order);
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
