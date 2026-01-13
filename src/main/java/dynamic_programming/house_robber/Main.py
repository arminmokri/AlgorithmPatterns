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

    def rob(self, nums: List[int]) -> int:
        if debug:
            print()

        if debug:
            print("nums=" + self.listToString(nums))

        if len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return nums[0]

        dp = [0] * (len(nums))

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        if debug and len(dp) < 20:
            print("dp=" + self.listToString(dp))

        for i in range(2, len(nums)):
            num = nums[i]
            dp[i] = max(num + dp[i - 2], dp[i - 1])

            if debug and len(dp) < 20:
                print("dp=" + self.listToString(dp))

        return dp[len(nums) - 1]


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.rob([1, 2, 3, 1]), 4)
        self.assertEqual(self.solution.rob([2, 7, 9, 3, 1]), 12)

    def test_edge_case_empty(self):
        self.assertEqual(self.solution.rob([]), 0)

    def test_edge_case_single_element(self):
        self.assertEqual(self.solution.rob([9]), 9)

    def test_edge_case_two_elements(self):
        self.assertEqual(self.solution.rob([4, 10]), 10)
        self.assertEqual(self.solution.rob([15, 1]), 15)

    def test_alternating_high_low(self):
        self.assertEqual(self.solution.rob([10, 1, 10, 1, 10]), 30)

    def test_all_same_values(self):
        self.assertEqual(self.solution.rob([5, 5, 5, 5, 5]), 15)

    def test_large_input(self):
        self.assertEqual(self.solution.rob([i for i in range(1, 101)]), 2550)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
