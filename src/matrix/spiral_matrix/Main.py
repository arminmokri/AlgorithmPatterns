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

    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """

        if debug:
            print()

        if debug:
            print("matrix=")
            print(self.martixToString(matrix))

        order = list()

        n = len(matrix)
        m = len(matrix[0]) if n > 0 else 0

        seen = [[False] * m for _ in range(n)]

        rowDir = (0, 1, 0, -1)
        colDir = (1, 0, -1, 0)
        dir = 0

        row = 0
        col = 0

        for _ in range(n * m):
            if debug:
                print(
                    "row="
                    + str(row)
                    + " col="
                    + str(col)
                    + " value="
                    + str(matrix[row][col])
                )

            if not seen[row][col]:
                seen[row][col] = True
                order.append(matrix[row][col])

            newRow = row + rowDir[dir]
            newCol = col + colDir[dir]

            if newRow not in range(n) or newCol not in range(m) or seen[newRow][newCol]:
                dir = (dir + 1) % 4
                newRow = row + rowDir[dir]
                newCol = col + colDir[dir]

            row = newRow
            col = newCol

        return order


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]),
            [1, 2, 3, 6, 9, 8, 7, 4, 5],
        )
        self.assertEqual(
            self.solution.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]),
            [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7],
        )

    def test_single_element(self):
        self.assertEqual(
            self.solution.spiralOrder([[5]]),
            [5],
        )

    def test_single_row(self):
        self.assertEqual(
            self.solution.spiralOrder([[1, 2, 3, 4]]),
            [1, 2, 3, 4],
        )

    def test_single_column(self):
        self.assertEqual(
            self.solution.spiralOrder([[1], [2], [3], [4]]),
            [1, 2, 3, 4],
        )

    def test_two_by_two(self):
        self.assertEqual(
            self.solution.spiralOrder([[1, 2], [4, 3]]),
            [1, 2, 3, 4],
        )

    def test_empty_matrix(self):
        self.assertEqual(
            self.solution.spiralOrder([]),
            [],
        )

    def test_matrix_with_one_empty_row(self):
        self.assertEqual(
            self.solution.spiralOrder([[]]),
            [],
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
