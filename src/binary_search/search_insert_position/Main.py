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

    def searchInsert(self, nums: List[int], target: int) -> int:
        if debug:
            print()

        if debug:
            print("num=" + str(nums))

        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            print("left=" + str(left) + " mid=" + str(mid) + " right=" + str(right))

            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                break

        return left


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.searchInsert([1, 3, 5, 6], 5), 2)
        self.assertEqual(self.solution.searchInsert([1, 3, 5, 6], 2), 1)
        self.assertEqual(self.solution.searchInsert([1, 3, 5, 6], 7), 4)

    def test_insert_at_beginning(self):
        self.assertEqual(self.solution.searchInsert([2, 4, 6, 8], 1), 0)

    def test_insert_at_end(self):
        self.assertEqual(self.solution.searchInsert([2, 4, 6, 8], 10), 4)

    def test_insert_middle(self):
        self.assertEqual(self.solution.searchInsert([1, 3, 5, 6], 4), 2)

    def test_target_already_present(self):
        self.assertEqual(self.solution.searchInsert([1, 3, 5, 6], 6), 3)

    def test_single_element_less_than_target(self):
        self.assertEqual(self.solution.searchInsert([3], 5), 1)

    def test_single_element_equal_to_target(self):
        self.assertEqual(self.solution.searchInsert([3], 3), 0)

    def test_single_element_greater_than_target(self):
        self.assertEqual(self.solution.searchInsert([3], 1), 0)

    def test_empty_list(self):
        self.assertEqual(self.solution.searchInsert([], 10), 0)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
