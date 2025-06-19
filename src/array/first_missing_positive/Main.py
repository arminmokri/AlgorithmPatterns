"""

Title: First Missing Positive

Given an unsorted integer array, find the smallest missing positive integer.
Your algorithm should run in O(n) time and use constant extra space.

Approach:
The idea is to rearrange the numbers so that each positive integer i is placed
at index i - 1. Then, scan the array to find the first index i such that A[i] != i + 1.
That index + 1 is the smallest missing positive.

Example:
Input: [3, 4, -1, 1]
Output: 2

"""

from typing import List, Tuple
import unittest

debug = True


class Solution:
    def martixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
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

    # Time Complexity O(n), Space Complexity O(n)
    def firstMissingPositive(self, nums: List[int]) -> int:
        if debug:
            print()

        myDict = dict()

        for item in nums:
            if item > 0:
                myDict[item] = item

        missing = 1
        while myDict.get(missing) is not None:
            missing = missing + 1

        return missing


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.firstMissingPositive([3, 4, -1, 1]), 2)
        self.assertEqual(self.solution.firstMissingPositive([1, 2, 3, 4, 5, 10]), 6)
        self.assertEqual(self.solution.firstMissingPositive([-1, -3]), 1)

    def test_all_positive_consecutive(self):
        self.assertEqual(self.solution.firstMissingPositive([1, 2, 3]), 4)

    def test_mixed_with_negatives(self):
        self.assertEqual(self.solution.firstMissingPositive([7, 8, 9, 11, 12]), 1)

    def test_unsorted_with_gap(self):
        self.assertEqual(self.solution.firstMissingPositive([2, 1, 0]), 3)

    def test_all_negatives(self):
        self.assertEqual(self.solution.firstMissingPositive([-1, -2, -3]), 1)

    def test_with_zero(self):
        self.assertEqual(self.solution.firstMissingPositive([0, 2, 2, 1, 1]), 3)

    def test_empty_list(self):
        self.assertEqual(self.solution.firstMissingPositive([]), 1)

    def test_large_input_gap_at_beginning(self):
        self.assertEqual(self.solution.firstMissingPositive([10, 12, 11]), 1)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
