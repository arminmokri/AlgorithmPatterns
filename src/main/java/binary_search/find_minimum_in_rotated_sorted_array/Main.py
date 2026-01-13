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

    def findMin(self, nums: List[int]) -> int:
        if debug:
            print()

        if debug:
            print("nums=" + str(nums))

        left = 0
        right = len(nums) - 1
        min_val = nums[0]

        while left <= right:
            mid = (left + right) // 2

            if debug:
                print("left=" + str(left) + " mid=" + str(mid) + " right=" + str(right))

            if nums[mid] >= nums[right]:
                left = mid + 1
            else:
                right = mid - 1

            min_val = min(min_val, nums[mid])

        return min_val


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.findMin([3, 4, 5, 1, 2]), 1)
        self.assertEqual(self.solution.findMin([4, 5, 6, 7, 0, 1, 2]), 0)
        self.assertEqual(self.solution.findMin([11, 13, 15, 17]), 11)

    def test_single_element(self):
        self.assertEqual(self.solution.findMin([42]), 42)

    def test_two_elements_rotated(self):
        self.assertEqual(self.solution.findMin([2, 1]), 1)

    def test_two_elements_not_rotated(self):
        self.assertEqual(self.solution.findMin([1, 2]), 1)

    def test_repeated_elements(self):
        self.assertEqual(self.solution.findMin([2, 2, 2, 0, 1, 2]), 0)

    def test_minimum_at_end(self):
        self.assertEqual(self.solution.findMin([2, 3, 4, 5, 1]), 1)

    def test_minimum_at_start(self):
        self.assertEqual(self.solution.findMin([0, 1, 2, 3, 4]), 0)

    def test_all_equal_elements(self):
        self.assertEqual(self.solution.findMin([5, 5, 5, 5]), 5)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
