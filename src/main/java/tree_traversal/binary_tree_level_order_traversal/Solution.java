package tree_traversal.binary_tree_level_order_traversal;

import common.PrintHelper;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        List<List<Integer>> order = new ArrayList<>();
        traversal(root, 0, order);
        return order;
    }

    private void traversal(TreeNode root, int level, List<List<Integer>> order) {
        if (Objects.isNull(root)) {
            return;
        }
        if (order.size() < level + 1) {
            order.add(new ArrayList<>());
        }

        order.get(Integer.valueOf(level)).add(root.val);
        traversal(root.left, level + 1, order);
        traversal(root.right, level + 1, order);
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
