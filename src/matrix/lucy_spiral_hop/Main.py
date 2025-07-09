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

    def lucySpiralHop(self, matrix: List[List[int]]) -> int:
        if debug:
            print()

        if debug:
            print("matrix=")
            print(self.martixToString(matrix))
            print()

        lastStop = None

        n = len(matrix)
        m = len(matrix[0])
        visited = [[False for _ in range(m)] for _ in range(n)]

        rowDir = (1, 0, -1, 0)
        colDir = (0, 1, 0, -1)
        dir = 0

        row = 0
        col = 0
        isStopPoint = True

        for i in range(n * m):
            if debug:
                print(
                    "row="
                    + str(row)
                    + " col="
                    + str(col)
                    + " value="
                    + str(matrix[row][col])
                    + " isStopPoint="
                    + str(isStopPoint)
                    + " visited=\n"
                    + self.martixToString(visited)
                )
                print()

            if not visited[row][col]:
                if isStopPoint:
                    lastStop = matrix[row][col]
                isStopPoint = not isStopPoint
                visited[row][col] = True

            newRow = row + rowDir[dir]
            newCol = col + colDir[dir]

            if (
                newRow not in range(n)
                or newCol not in range(m)
                or visited[newRow][newCol]
            ):
                dir = (dir + 1) % 4
                newRow = row + rowDir[dir]
                newCol = col + colDir[dir]

            row = newRow
            col = newCol

        return lastStop


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.lucySpiralHop([[29, 8, 37], [15, 41, 3], [1, 10, 14]]), 41
        )

    def test_single_element(self):
        self.assertEqual(self.solution.lucySpiralHop([[5]]), 5)

    def test_single_row(self):
        self.assertEqual(self.solution.lucySpiralHop([[1, 2, 3, 4, 5]]), 5)

    def test_single_column(self):
        self.assertEqual(self.solution.lucySpiralHop([[1], [2], [3], [4]]), 3)

    def test_even_sized_square(self):
        self.assertEqual(self.solution.lucySpiralHop([[1, 2], [4, 3]]), 3)

    def test_larger_matrix(self):
        self.assertEqual(
            self.solution.lucySpiralHop(
                [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
            ),
            15,
        )

    def test_rectangular_matrix(self):
        self.assertEqual(
            self.solution.lucySpiralHop(
                [[1, 2, 3], [10, 11, 4], [9, 12, 5], [8, 7, 6]]
            ),
            11,
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
