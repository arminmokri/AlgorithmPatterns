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

    def search(self, nums: list[int], target: int) -> int:
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        if debug:
            print()

        left = 0
        right = len(nums) - 1
        index = -1

        while left <= right:
            mid = int((left + right) / 2)

            if debug:
                print("left=" + str(left) + " mid=" + str(mid) + " right=" + str(right))

            if target == nums[mid]:
                index = mid
                break
            elif target < nums[mid]:
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1

        return index


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.search([-1, 0, 3, 5, 9, 12], 9), 4)
        self.assertEqual(self.solution.search([-1, 0, 3, 5, 9, 12], 2), -1)

    def test_empty_array(self):
        self.assertEqual(self.solution.search([], 1), -1)

    def test_single_element_found(self):
        self.assertEqual(self.solution.search([5], 5), 0)

    def test_single_element_not_found(self):
        self.assertEqual(self.solution.search([5], 1), -1)

    def test_target_at_beginning(self):
        self.assertEqual(self.solution.search([1, 3, 5, 7], 1), 0)

    def test_target_at_end(self):
        self.assertEqual(self.solution.search([1, 3, 5, 7], 7), 3)

    def test_target_in_middle(self):
        self.assertEqual(self.solution.search([1, 3, 5, 7, 9], 5), 2)

    def test_negative_numbers(self):
        self.assertEqual(self.solution.search([-10, -5, -2, 0, 3], -5), 1)

    def test_large_array(self):
        nums = list(range(0, 10000, 2))  # even numbers from 0 to 9998
        self.assertEqual(self.solution.search(nums, 678), 339)
        self.assertEqual(self.solution.search(nums, 9999), -1)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
