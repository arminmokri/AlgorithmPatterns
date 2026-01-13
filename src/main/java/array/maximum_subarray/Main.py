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

    def maxSubArray(self, nums: List[int]) -> int:
        if debug:
            print()

        max = None
        sum = 0

        for num in nums:
            if sum < 0:
                sum = 0

            sum = sum + num
            if max is None or sum > max:
                max = sum

        if debug:
            print("max=" + str(max) + " nums=" + str(nums))

        return max


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]), 6)
        self.assertEqual(self.solution.maxSubArray([1]), 1)
        self.assertEqual(self.solution.maxSubArray([5, 4, -1, 7, 8]), 23)

    def test_all_negative(self):
        self.assertEqual(self.solution.maxSubArray([-1, -2, -3, -4]), -1)

    def test_all_positive(self):
        self.assertEqual(self.solution.maxSubArray([1, 2, 3, 4, 5]), 15)

    def test_single_element(self):
        self.assertEqual(self.solution.maxSubArray([-100]), -100)
        self.assertEqual(self.solution.maxSubArray([0]), 0)
        self.assertEqual(self.solution.maxSubArray([100]), 100)

    def test_mixed_with_zeroes(self):
        self.assertEqual(self.solution.maxSubArray([-2, 0, -1]), 0)

    def test_large_input(self):
        self.assertEqual(self.solution.maxSubArray([1] * 10000), 10000)

    def test_max_at_end(self):
        self.assertEqual(self.solution.maxSubArray([-3, -2, 5, 6]), 11)

    def test_max_at_start(self):
        self.assertEqual(self.solution.maxSubArray([10, -1, -2, -3]), 10)

    def test_max_in_middle(self):
        self.assertEqual(self.solution.maxSubArray([-5, 4, -1, 2, 1, -5]), 6)

    def test_multiple_same_max_subarrays(self):
        self.assertEqual(self.solution.maxSubArray([1, -1, 1, -1, 1]), 1)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
