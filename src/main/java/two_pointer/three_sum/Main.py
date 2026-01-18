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

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if debug:
            print()

        triplets = list()

        nums.sort()

        if debug:
            print("nums=" + str(nums))

        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            first_num = nums[i]
            target = -first_num

            left_pointer = i + 1
            right_pointer = len(nums) - 1

            while left_pointer < right_pointer:
                second_number = nums[left_pointer]
                third_number = nums[right_pointer]
                sum = second_number + third_number
                if sum == target:
                    triplet = [first_num, second_number, third_number]
                    if triplet not in triplets:
                        triplets.append(triplet)
                    left_pointer = left_pointer + 1
                elif sum < target:
                    left_pointer = left_pointer + 1
                elif sum > target:
                    right_pointer = right_pointer - 1

        if debug:
            print("triplets=" + str(triplets))

        return triplets


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertAlmostEqual(
            self.solution.threeSum([-1, 0, 1, 2, -1, -4]), [[-1, -1, 2], [-1, 0, 1]]
        )
        self.assertCountEqual(self.solution.threeSum([0, 1, 1]), [])
        self.assertCountEqual(self.solution.threeSum([0, 0, 0]), [[0, 0, 0]])

    def test_mirror_list_case(self):
        self.assertCountEqual(
            self.solution.threeSum([0, -3, -2, 2, 3]), [[-3, 0, 3], [-2, 0, 2]]
        )

    def test_empty_and_too_short_inputs(self):
        self.assertCountEqual(self.solution.threeSum([]), [])
        self.assertCountEqual(self.solution.threeSum([0]), [])
        self.assertCountEqual(self.solution.threeSum([0, 0]), [])

    def test_all_positive_or_all_negative(self):
        self.assertCountEqual(self.solution.threeSum([1, 2, 3, 4, 5]), [])
        self.assertCountEqual(self.solution.threeSum([-5, -4, -3, -2, -1]), [])

    def test_many_duplicates_single_triplet(self):
        self.assertCountEqual(self.solution.threeSum([0, 0, 0, 0, 0]), [[0, 0, 0]])
        self.assertCountEqual(
            self.solution.threeSum([-1, -1, -1, 2, 2, 2]), [[-1, -1, 2]]
        )

    def test_multiple_triplets_with_duplicates(self):
        # Classic case with duplicates that should not duplicate output triplets
        self.assertCountEqual(
            self.solution.threeSum([-2, 0, 0, 2, 2]),
            [[-2, 0, 2]],
        )
        self.assertCountEqual(
            self.solution.threeSum([-4, -2, -2, -2, 0, 1, 2, 2, 2, 4]),
            [[-4, 0, 4], [-4, 2, 2], [-2, -2, 4], [-2, 0, 2]],
        )

    def test_unsorted_input_and_order_independence(self):
        # Same values, shuffled; result should be the same set of triplets
        nums = [3, -1, -7, 4, 5, -4, 2, -2, -3, 1, 6]
        expected = [
            [-7, 1, 6],
            [-7, 2, 5],
            [-7, 3, 4],
            [-4, -2, 6],
            [-4, -1, 5],
            [-4, 1, 3],
            [-3, -2, 5],
            [-3, -1, 4],
            [-3, 1, 2],
            [-2, -1, 3],
        ]
        self.assertCountEqual(self.solution.threeSum(nums), expected)

    def test_large_magnitude_numbers(self):
        self.assertCountEqual(
            self.solution.threeSum([-(10**9), 0, 10**9]),
            [[-(10**9), 0, 10**9]],
        )
        self.assertCountEqual(
            self.solution.threeSum([-(10**9), -(10**9), 2 * 10**9, 1]),
            [[-(10**9), -(10**9), 2 * 10**9]],
        )

    def test_triplets_with_zero_and_pairs(self):
        self.assertCountEqual(
            self.solution.threeSum([-1, 0, 1, 0]),
            [[-1, 0, 1]],
        )
        self.assertCountEqual(
            self.solution.threeSum([-2, -1, 0, 1, 2, 3, -3]),
            [[-3, 0, 3], [-3, 1, 2], [-2, -1, 3], [-2, 0, 2], [-1, 0, 1]],
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
