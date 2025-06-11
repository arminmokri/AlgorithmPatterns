import unittest

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def maxArea(self, height: list[int]) -> int:
        """
        :type height: List[int]
        :rtype: int
        """
        left = 0
        right = len(height) - 1

        max_area = 0

        while left < right:
            h = min(height[left], height[right])
            w = right - left
            area = h * w
            if area > max_area:
                max_area = area

            if height[left] > height[right]:
                right = right - 1
            elif height[left] <= height[right]:
                left = left + 1

        return max_area


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]), 49)
        self.assertEqual(self.solution.maxArea([1, 1]), 1)

    def test_empty_list(self):
        self.assertEqual(self.solution.maxArea([]), 0)

    def test_single_element(self):
        self.assertEqual(self.solution.maxArea([5]), 0)

    def test_all_same_height(self):
        self.assertEqual(self.solution.maxArea([5, 5, 5, 5, 5]), 20)

    def test_monotonically_increasing(self):
        self.assertEqual(self.solution.maxArea([1, 2, 3, 4, 5]), 6)

    def test_monotonically_decreasing(self):
        self.assertEqual(self.solution.maxArea([5, 4, 3, 2, 1]), 6)

    def test_plateaus(self):
        self.assertEqual(self.solution.maxArea([2, 2, 2, 2, 2]), 8)

    def test_valleys(self):
        self.assertEqual(self.solution.maxArea([5, 1, 5]), 10)

    def test_high_peaks_edges(self):
        self.assertEqual(self.solution.maxArea([10, 1, 1, 1, 10]), 40)

    def test_large_input(self):
        heights = [1] * 10000
        self.assertEqual(self.solution.maxArea(heights), 9999)

    def test_middle_peak(self):
        self.assertEqual(
            self.solution.maxArea([6, 3, 9, 7, 8, 5, 100, 100, 7, 8, 6, 5, 7, 8]), 100
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
