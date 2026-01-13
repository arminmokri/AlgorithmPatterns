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

    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        if debug:
            print()

        left = 0
        mid = 0
        right = len(nums) - 1

        while mid <= right:
            if nums[mid] == 0:
                nums[left], nums[mid] = nums[mid], nums[left]
                left = left + 1
                mid = mid + 1
            elif nums[mid] == 1:
                mid = mid + 1
            elif nums[mid] == 2:
                nums[mid], nums[right] = nums[right], nums[mid]
                right = right - 1

        if debug:
            print("nums=" + str(nums))


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        nums = [2, 0, 2, 1, 1, 0]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [0, 0, 1, 1, 2, 2])

        nums = [2, 0, 1]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [0, 1, 2])

    def test_all_zeros(self):
        nums = [0, 0, 0, 0]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [0, 0, 0, 0])

    def test_all_ones(self):
        nums = [1, 1, 1, 1]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [1, 1, 1, 1])

    def test_all_twos(self):
        nums = [2, 2, 2]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [2, 2, 2])

    def test_empty_array(self):
        nums = []
        self.solution.sortColors(nums)
        self.assertEqual(nums, [])

    def test_mixed_sorted_input(self):
        nums = [0, 1, 2, 0, 1, 2]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [0, 0, 1, 1, 2, 2])

    def test_already_sorted(self):
        nums = [0, 0, 1, 1, 2, 2]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [0, 0, 1, 1, 2, 2])

    def test_reverse_sorted(self):
        nums = [2, 2, 1, 1, 0, 0]
        self.solution.sortColors(nums)
        self.assertEqual(nums, [0, 0, 1, 1, 2, 2])


def main():
    unittest.main()


if __name__ == "__main__":
    main()
