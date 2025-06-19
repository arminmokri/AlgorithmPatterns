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

    def removeDuplicates(self, nums: List[int]):
        if debug:
            print()

        last_item = None

        i = 0
        while i < len(nums):
            num = nums[i]

            if last_item is None:
                last_item = num
                i = i + 1
                continue
            elif last_item == num:
                del nums[i]
            else:
                last_item = num
                i = i + 1

        if debug:
            print("len=" + str(len(nums)) + " nums=" + str(nums))

        return len(nums)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        nums = [1, 1, 2]
        k = self.solution.removeDuplicates(nums)
        self.assertEqual(k, 2)
        self.assertEqual(nums[:k], [1, 2])

        nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
        k = self.solution.removeDuplicates(nums)
        self.assertEqual(k, 5)
        self.assertEqual(nums[:k], [0, 1, 2, 3, 4])

    def test_empty_list(self):
        nums = []
        k = self.solution.removeDuplicates(nums)
        self.assertEqual(k, 0)
        self.assertEqual(nums[:k], [])

    def test_single_element(self):
        nums = [42]
        k = self.solution.removeDuplicates(nums)
        self.assertEqual(k, 1)
        self.assertEqual(nums[:k], [42])

    def test_all_unique(self):
        nums = [1, 2, 3, 4, 5]
        k = self.solution.removeDuplicates(nums)
        self.assertEqual(k, 5)
        self.assertEqual(nums[:k], [1, 2, 3, 4, 5])

    def test_all_duplicates(self):
        nums = [9, 9, 9, 9]
        k = self.solution.removeDuplicates(nums)
        self.assertEqual(k, 1)
        self.assertEqual(nums[:k], [9])

    def test_two_duplicates_in_middle(self):
        nums = [1, 2, 2, 3, 4]
        k = self.solution.removeDuplicates(nums)
        self.assertEqual(k, 4)
        self.assertEqual(nums[:k], [1, 2, 3, 4])


def main():
    unittest.main()


if __name__ == "__main__":
    main()
