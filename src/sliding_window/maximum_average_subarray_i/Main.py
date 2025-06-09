import unittest
import sys

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def findMaxAverage(self, nums: list[int], k: int) -> float:
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """

        if debug:
            print()

        if debug:
            print("nums=" + str(nums))

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

    def test_default_case(self):
        self.assertEqual(self.solution.findMaxAverage([1, 12, -5, -6, 50, 3], 4), 12.75)
        self.assertEqual(self.solution.findMaxAverage([5], 1), 5)

    def test_all_positive(self):
        self.assertEqual(self.solution.findMaxAverage([1, 2, 3, 4, 5], 2), 4.5)

    def test_all_negative(self):
        self.assertEqual(self.solution.findMaxAverage([-1, -2, -3, -4], 2), -1.5)

    def test_single_element_window(self):
        self.assertEqual(self.solution.findMaxAverage([5, 1, -2, 3], 1), 5)

    def test_full_array_window(self):
        self.assertEqual(self.solution.findMaxAverage([2, 4, 6, 8], 4), 5)

    def test_large_numbers(self):
        self.assertEqual(
            self.solution.findMaxAverage([1000000, 1000000, 1000000], 2), 1000000
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
