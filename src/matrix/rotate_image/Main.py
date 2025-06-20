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

    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """

        if debug:
            print()

        if debug:
            print("matrix=")
            print(self.martixToString(matrix))

        n = len(matrix)
        m = len(matrix[0]) if n > 0 else 0

        up = 0
        down = n - 1

        while up < down:
            for col in range(m):
                matrix[down][col], matrix[up][col] = matrix[up][col], matrix[down][col]
            up = up + 1
            down = down - 1

        for i in range(n):
            for j in range(i + 1, m):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        if debug:
            print("matrix=")
            print(self.martixToString(matrix))


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        expected = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        self.solution.rotate(matrix)
        self.assertEqual(matrix, expected)

        matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
        expected = [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
        self.solution.rotate(matrix)
        self.assertEqual(matrix, expected)

    def test_single_element(self):
        matrix = [[42]]
        expected = [[42]]
        self.solution.rotate(matrix)
        self.assertEqual(matrix, expected)

    def test_2x2_matrix(self):
        matrix = [[1, 2], [3, 4]]
        expected = [[3, 1], [4, 2]]
        self.solution.rotate(matrix)
        self.assertEqual(matrix, expected)

    def test_empty_matrix(self):
        matrix = []
        expected = []
        self.solution.rotate(matrix)
        self.assertEqual(matrix, expected)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
