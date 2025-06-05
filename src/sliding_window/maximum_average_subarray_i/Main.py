import sys
import unittest

debug = True


class Solution:
    def findMaxAverage(self, nums: list[int], k: int) -> float:
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """

        maxAvg = -sys.maxsize + 1

        for i in range(len(nums) - (k - 1)):
            subNums = nums[i : i + k]

            if debug:
                print("subNums=" + str(subNums))

            mySum = sum(subNums) / k
            if mySum > maxAvg:
                maxAvg = mySum

        if debug:
            print("maxAvg=" + str(maxAvg))

        return maxAvg


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_basic_case(self):
        self.assertAlmostEqual(
            self.solution.findMaxAverage([1, 12, -5, -6, 50, 3], 4), 12.75
        )
        self.assertAlmostEqual(self.solution.findMaxAverage([5], 1), 5)

    def test_all_positive(self):
        self.assertAlmostEqual(self.solution.findMaxAverage([1, 2, 3, 4, 5], 2), 4.5)

    def test_all_negative(self):
        self.assertAlmostEqual(self.solution.findMaxAverage([-1, -2, -3, -4], 2), -1.5)

    def test_single_element_window(self):
        self.assertAlmostEqual(self.solution.findMaxAverage([5, 1, -2, 3], 1), 5.0)

    def test_full_array_window(self):
        self.assertAlmostEqual(self.solution.findMaxAverage([2, 4, 6, 8], 4), 5.0)

    def test_large_numbers(self):
        self.assertAlmostEqual(
            self.solution.findMaxAverage([1000000, 1000000, 1000000], 2), 1000000.0
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
