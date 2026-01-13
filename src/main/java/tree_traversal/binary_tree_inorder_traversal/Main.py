from typing import List, Tuple, Optional
from collections import deque
import unittest

debug = True


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Tree(object):
    @staticmethod
    def build_tree(values: List[Optional[int]]) -> TreeNode:
        """
        Builds a binary tree from a level-order list.
        :param values: List[Optional[int]]
        :return: TreeNode | None
        """
        if not values:
            return None

        root = TreeNode(values[0])
        queue = deque([root])
        i = 1

        while queue and i < len(values):
            current = queue.popleft()

            # Left child
            if i < len(values) and values[i] is not None:
                current.left = TreeNode(values[i])
                queue.append(current.left)
            i += 1

            # Right child
            if i < len(values) and values[i] is not None:
                current.right = TreeNode(values[i])
                queue.append(current.right)
            i += 1

        return root


class Solution:
    def matrixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
        if myMatrix == []:
            return "[]"
        elif myMatrix == [[]]:
            return "[[]]"

        str_matrix = [[str(val) for val in row] for row in myMatrix]
        max_width = max(len(val) for row in str_matrix for val in row)

        return "\n".join(
            "[ " + ", ".join(f"{val:>{max_width}}" for val in row) + " ]"
            for row in str_matrix
        )

    def listToString(self, myList: List | Tuple) -> str:
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if debug:
            print()

        order = list()

        def traversal(node: TreeNode) -> None:
            if node is not None:
                traversal(node.left)
                order.append(node.val)
                traversal(node.right)

        traversal(root)

        if debug:
            print("order=" + str(order))

        return order


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        # Input: [1, null, 2, 3]
        # Tree:         1
        #                \
        #                 2
        #                /
        #               3
        root = Tree.build_tree([1, None, 2, 3])
        self.assertEqual(self.solution.inorderTraversal(root), [1, 3, 2])

        # Input: [1,2,3,4,5,null,8,null,null,6,7,9]
        # Tree:             1
        #                 /   \
        #               2       3
        #              / \       \
        #             4   5       8
        #                / \     /
        #               6   7   9
        root = Tree.build_tree([1, 2, 3, 4, 5, None, 8, None, None, 6, 7, 9])
        self.assertEqual(
            self.solution.inorderTraversal(root), [4, 2, 6, 5, 7, 1, 3, 9, 8]
        )

        # Input: []
        # Tree: empty
        root = Tree.build_tree([])
        self.assertEqual(self.solution.inorderTraversal(root), [])

        # Input: [1]
        # Tree: 1
        root = Tree.build_tree([1])
        self.assertEqual(self.solution.inorderTraversal(root), [1])

    def test_empty_tree(self):
        # Tree: empty
        root = Tree.build_tree([])
        self.assertEqual(self.solution.inorderTraversal(root), [])

    def test_single_node(self):
        # Tree: 1
        root = Tree.build_tree([1])
        self.assertEqual(self.solution.inorderTraversal(root), [1])

    def test_right_skewed_tree(self):
        # Tree:     1
        #            \
        #             2
        #              \
        #               3
        root = Tree.build_tree([1, None, 2, None, 3])
        self.assertEqual(self.solution.inorderTraversal(root), [1, 2, 3])

    def test_left_skewed_tree(self):
        # Tree:         3
        #              /
        #            2
        #           /
        #         1
        root = Tree.build_tree([3, 2, None, 1])
        self.assertEqual(self.solution.inorderTraversal(root), [1, 2, 3])

    def test_balanced_tree(self):
        # Tree:      1
        #           / \
        #          2   3
        root = Tree.build_tree([1, 2, 3])
        self.assertEqual(self.solution.inorderTraversal(root), [2, 1, 3])


def main():
    unittest.main()


if __name__ == "__main__":
    main()
