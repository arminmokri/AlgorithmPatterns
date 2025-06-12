import unittest

debug = True


class Solution:
    def martixToString(self, myMatrix: list[list] | tuple[tuple]) -> str:
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

    def listToString(self, myList: list | tuple) -> str:
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def lengthOfLIS(self, nums: list[int]) -> int:
        """
        :type nums: List[int]
        :rtype: int
        """

        if debug:
            print()

        if nums == []:
            return 0

        dp = [1] * (len(nums))

        if debug and len(nums) < 20:
            print("nums=" + self.listToString(nums))
            print("dp=" + self.listToString(dp))

        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j] and dp[i] < dp[j] + 1:
                    dp[i] = dp[j] + 1

            if debug and len(nums) < 20:
                print("num=" + str(nums[i]) + " dp=" + self.listToString(dp))
        return max(dp)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]), 4)
        self.assertEqual(self.solution.lengthOfLIS([0, 1, 0, 3, 2, 3]), 4)
        self.assertEqual(self.solution.lengthOfLIS([7, 7, 7, 7, 7, 7, 7]), 1)

    def test_empty_list(self):
        self.assertEqual(self.solution.lengthOfLIS([]), 0)

    def test_single_element(self):
        self.assertEqual(self.solution.lengthOfLIS([42]), 1)

    def test_strictly_increasing(self):
        self.assertEqual(self.solution.lengthOfLIS([1, 2, 3, 4, 5, 6]), 6)

    def test_strictly_decreasing(self):
        self.assertEqual(self.solution.lengthOfLIS([6, 5, 4, 3, 2, 1]), 1)

    def test_alternating_up_down(self):
        self.assertEqual(self.solution.lengthOfLIS([1, 3, 2, 4, 3, 5]), 4)

    def test_duplicate_elements(self):
        self.assertEqual(self.solution.lengthOfLIS([1, 2, 2, 2, 3]), 3)

    def test_all_same_except_one(self):
        self.assertEqual(self.solution.lengthOfLIS([2, 2, 2, 2, 3]), 2)

    def test_large_input(self):
        self.assertEqual(self.solution.lengthOfLIS(list(range(1000))), 1000)

    def test_zigzag_pattern(self):
        self.assertEqual(self.solution.lengthOfLIS([3, 1, 2, 1, 5, 4, 6]), 4)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
