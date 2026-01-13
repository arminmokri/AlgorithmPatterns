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

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if debug:
            print()

        levels = list()

        seen = set()

        queue = deque()

        queue.append([root, 0]) if root is not None else None

        while len(queue) > 0:
            node, level = queue.popleft()

            if len(levels) <= level:
                levels.append([node.val])
            else:
                levels[level].append(node.val)

            for child in [node.left, node.right]:
                if child is not None and child not in seen:
                    queue.append([child, level + 1])

        if debug:
            print("levels=" + str(levels))

        return levels


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        # Input: [3,9,20,null,null,15,7]
        # Tree:
        #         3
        #        / \
        #       9  20
        #          / \
        #         15  7
        root = Tree.build_tree([3, 9, 20, None, None, 15, 7])
        self.assertEqual(self.solution.levelOrder(root), [[3], [9, 20], [15, 7]])

        # Input: [1]
        # Tree: 1
        root = Tree.build_tree([1])
        self.assertEqual(self.solution.levelOrder(root), [[1]])

        # Input: []
        # Tree: empty
        root = Tree.build_tree([])
        self.assertEqual(self.solution.levelOrder(root), [])

    def test_empty_tree(self):
        # Tree: empty
        root = Tree.build_tree([])
        self.assertEqual(self.solution.levelOrder(root), [])

    def test_single_node(self):
        # Tree: 1
        root = Tree.build_tree([1])
        self.assertEqual(self.solution.levelOrder(root), [[1]])

    def test_right_skewed_tree(self):
        # Tree:     1
        #            \
        #             2
        #              \
        #               3
        root = Tree.build_tree([1, None, 2, None, 3])
        self.assertEqual(self.solution.levelOrder(root), [[1], [2], [3]])

    def test_left_skewed_tree(self):
        # Tree:         3
        #              /
        #            2
        #           /
        #         1
        root = Tree.build_tree([3, 2, None, 1])
        self.assertEqual(self.solution.levelOrder(root), [[3], [2], [1]])

    def test_balanced_tree(self):
        # Tree:      1
        #           / \
        #          2   3
        root = Tree.build_tree([1, 2, 3])
        self.assertEqual(self.solution.levelOrder(root), [[1], [2, 3]])


def main():
    unittest.main()


if __name__ == "__main__":
    main()
