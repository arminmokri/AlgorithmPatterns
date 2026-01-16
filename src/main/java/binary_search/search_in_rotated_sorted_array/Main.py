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

    def search(self, nums: List[int], target: int) -> int:
        if debug:
            print()

        if debug:
            print("target=" + str(target) + " nums=" + self.listToString(nums))

        index = -1
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if debug:
                s = "left=" + str(left) + " mid=" + str(mid) + " right=" + str(right)

            if nums[mid] == target:
                index = mid
                break
            elif nums[left] <= nums[mid]:  # Left half is sorted
                if debug:
                    s = s + ", left half is sorted"
                if nums[left] <= target and target < nums[mid]:
                    if debug:
                        s = s + ", target is in left half"
                    right = mid - 1
                else:
                    if debug:
                        s = s + ", target is in right half"
                    left = mid + 1
            else:  # Right half is sorted
                if debug:
                    s = s + ", right half is sorted"
                if nums[mid] < target and target <= nums[right]:
                    if debug:
                        s = s + ", target is in right half"
                    left = mid + 1
                else:
                    if debug:
                        s = s + ", target is in left half"
                    right = mid - 1

            if debug:
                print(s)

        return index


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.search([4, 5, 6, 7, 0, 1, 2], 0), 4)
        self.assertEqual(self.solution.search([4, 5, 6, 7, 0, 1, 2], 3), -1)
        self.assertEqual(self.solution.search([1], 0), -1)

    def test_single_element_found(self):
        self.assertEqual(self.solution.search([1], 1), 0)

    def test_target_at_start(self):
        self.assertEqual(self.solution.search([6, 7, 0, 1, 2, 3, 4, 5], 6), 0)

    def test_target_at_end(self):
        self.assertEqual(self.solution.search([6, 7, 0, 1, 2, 3, 4, 5], 5), 7)

    def test_empty_array(self):
        self.assertEqual(self.solution.search([], 3), -1)

    def test_target_not_in_array(self):
        self.assertEqual(self.solution.search([6, 7, 0, 1, 2, 3, 4, 5], 8), -1)

    def test_rotated_array_different_pivot(self):
        self.assertEqual(self.solution.search([3, 4, 5, 6, 7, 0, 1, 2], 0), 5)
        self.assertEqual(self.solution.search([2, 3, 4, 5, 6, 7, 0, 1], 0), 6)

    def test_unrotated_sorted_array(self):
        self.assertEqual(self.solution.search([0, 1, 2, 3, 4, 5, 6, 7], 4), 4)
        self.assertEqual(self.solution.search([0, 1, 2, 3, 4, 5, 6, 7], 8), -1)

    def test_duplicates_in_array(self):
        self.assertEqual(self.solution.search([2, 2, 2, 3, 4, 2, 2], 3), 3)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
