from typing import List, Tuple
import unittest

debug = True


class Solution:
    def martixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
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

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def bs_find_row(matrix, target) -> int:
            n = len(matrix)
            m = len(matrix[0]) if n > 0 else 0
            row = -1
            up = 0
            down = n - 1
            while m > 0 and up <= down:
                mid = (up + down) // 2
                if target >= matrix[mid][0] and target <= matrix[mid][m - 1]:
                    row = mid
                    break
                elif target < matrix[mid][0]:
                    down = mid - 1
                elif target > matrix[mid][0]:
                    up = mid + 1
            return row

        def bs_find_in_row(matrix, row, target) -> int:
            if row == -1:
                return -1
            n = len(matrix)
            m = len(matrix[0]) if n > 0 else 0
            index = -1
            left = 0
            right = m - 1
            while left <= right:
                mid = (left + right) // 2
                if target == matrix[row][mid]:
                    index = mid
                    break
                elif target < matrix[row][mid]:
                    right = mid - 1
                elif target > matrix[row][mid]:
                    left = mid + 1
            return index

        if debug:
            print()

        if debug:
            print("matrix=")
            print(self.martixToString(matrix))

        row = bs_find_row(matrix, target)
        col = bs_find_in_row(matrix, row, target)

        if debug:
            print("target=" + str(target) + " row=" + str(row) + " col=" + str(col))

        return col >= 0


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertTrue(
            self.solution.searchMatrix(
                [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3
            )
        )

        self.assertFalse(
            self.solution.searchMatrix(
                [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 13
            )
        )

    def test_first_element(self):
        self.assertTrue(self.solution.searchMatrix([[1, 2], [3, 4]], 1))

    def test_last_element(self):
        self.assertTrue(self.solution.searchMatrix([[1, 2], [3, 4]], 4))

    def test_single_row_matrix(self):
        self.assertTrue(self.solution.searchMatrix([[1, 2, 3, 4]], 3))
        self.assertFalse(self.solution.searchMatrix([[1, 2, 3, 4]], 5))

    def test_single_column_matrix(self):
        self.assertTrue(self.solution.searchMatrix([[1], [2], [3]], 2))
        self.assertFalse(self.solution.searchMatrix([[1], [2], [3]], 5))

    def test_empty_matrix(self):
        self.assertFalse(self.solution.searchMatrix([], 1))

    def test_empty_rows(self):
        self.assertFalse(self.solution.searchMatrix([[]], 1))

    def test_target_not_in_range(self):
        self.assertFalse(self.solution.searchMatrix([[10, 20], [30, 40]], 5))
        self.assertFalse(self.solution.searchMatrix([[10, 20], [30, 40]], 50))

    def test_duplicate_values(self):
        self.assertTrue(self.solution.searchMatrix([[1, 1, 1], [1, 1, 1]], 1))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
