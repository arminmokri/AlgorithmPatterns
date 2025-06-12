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

    def permute(self, nums: list[int]) -> list[list[int]]:
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        if debug:
            print()

        def backtracking(nums: list[int]) -> list[list[int]]:
            if len(nums) == 0 or len(nums) == 1:
                return [nums[:]]

            permutes = []

            for _ in range(len(nums)):
                num = nums.pop(0)

                if debug:
                    print("num=" + str(num) + " nums=" + str(nums))

                sub_permutes = backtracking(nums)

                for sub_permute in sub_permutes:
                    sub_permute.append(num)

                permutes.extend(sub_permutes)

                nums.append(num)

            if debug:
                print("permutes=" + str(permutes))

            return permutes

        return backtracking(nums)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertCountEqual(
            self.solution.permute([1, 2, 3]),
            [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]],
        )
        self.assertCountEqual(self.solution.permute([0, 1]), [[0, 1], [1, 0]])
        self.assertCountEqual(self.solution.permute([1]), [[1]])

    def test_empty_list(self):
        self.assertCountEqual(self.solution.permute([]), [[]])

    def test_with_negative_numbers(self):
        self.assertCountEqual(
            self.solution.permute([-1, 0, 1]),
            [[-1, 0, 1], [-1, 1, 0], [0, -1, 1], [0, 1, -1], [1, -1, 0], [1, 0, -1]],
        )

    def test_four_elements(self):
        result = self.solution.permute([1, 2, 3, 4])
        self.assertEqual(len(result), 24)
        self.assertIn([4, 3, 2, 1], result)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
