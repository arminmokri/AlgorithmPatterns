from typing import List, Tuple
import unittest

debug = True


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

    def isMonotonic(self, nums: List[int]) -> bool:
        if debug:
            print()

        isMonotonic = True

        first_item = nums[0] if len(nums) > 0 else None
        last_item = nums[len(nums) - 1] if len(nums) > 0 else None

        dir = None
        if first_item is not None and last_item >= first_item:
            dir = 0  # inc
        else:
            dir = 1  # dec

        prev_item = first_item
        for i in range(1, len(nums)):
            if dir == 0:
                if not nums[i] >= prev_item:
                    isMonotonic = False
                    break
            else:
                if not nums[i] <= prev_item:
                    isMonotonic = False
                    break

            prev_item = nums[i]

        return isMonotonic


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertTrue(self.solution.isMonotonic([1, 2, 2, 3]))
        self.assertTrue(self.solution.isMonotonic([6, 5, 4, 4]))
        self.assertFalse(self.solution.isMonotonic([1, 3, 2]))

    def test_edge_cases(self):
        # Empty list is trivially monotonic
        self.assertTrue(self.solution.isMonotonic([]))

        # Single element is always monotonic
        self.assertTrue(self.solution.isMonotonic([10]))

        # Two elements (increasing)
        self.assertTrue(self.solution.isMonotonic([1, 2]))

        # Two elements (decreasing)
        self.assertTrue(self.solution.isMonotonic([2, 1]))

        # All elements equal (constant)
        self.assertTrue(self.solution.isMonotonic([3, 3, 3, 3]))

    def test_not_monotonic(self):
        # Increasing then decreasing
        self.assertFalse(self.solution.isMonotonic([1, 3, 2]))

        # Decreasing then increasing
        self.assertFalse(self.solution.isMonotonic([5, 3, 4]))

        # Mixed fluctuations
        self.assertFalse(self.solution.isMonotonic([1, 2, 1, 2, 1]))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
