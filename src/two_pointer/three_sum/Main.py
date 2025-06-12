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

    def threeSum(self, nums: list) -> list:
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

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


def main():
    unittest.main()


if __name__ == "__main__":
    main()
