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
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def numIslands(self, grid: list[list[str]]) -> int:
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        if debug:
            print()

        if debug:
            print("grid=")
            print(self.martixToString(grid))

        n = len(grid)
        m = len(grid[0])

        integrity = [[False] * m for _ in range(n)]

        number_of_islands = 0

        for i in range(n):
            for j in range((m)):
                if grid[i][j] == "0":
                    continue

                if grid[i][j] == "1":
                    if not integrity[i][j]:
                        integrity[i][j] = True
                        number_of_islands = number_of_islands + 1

                    if i + 1 < n and grid[i + 1][j] == "1":
                        integrity[i + 1][j] = True
                    if j + 1 < m and grid[i][j + 1] == "1":
                        integrity[i][j + 1] = True
                if debug:
                    print("i=" + str(i) + " j=" + str(j) + " integrity=")
                    print(self.martixToString(integrity))

        if debug:
            print("number_of_islands=" + str(number_of_islands))

        return number_of_islands


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.numIslands(
                [
                    ["1", "1", "1", "1", "0"],
                    ["1", "1", "0", "1", "0"],
                    ["1", "1", "0", "0", "0"],
                    ["0", "0", "0", "0", "0"],
                ]
            ),
            1,
        )
        self.assertEqual(
            self.solution.numIslands(
                [
                    ["1", "1", "0", "0", "0"],
                    ["1", "1", "0", "0", "0"],
                    ["0", "0", "1", "0", "0"],
                    ["0", "0", "0", "1", "1"],
                ]
            ),
            3,
        )

    def test_single_land_tile(self):
        self.assertEqual(self.solution.numIslands([["1"]]), 1)

    def test_single_water_tile(self):
        self.assertEqual(self.solution.numIslands([["0"]]), 0)

    def test_empty_grid(self):
        self.assertEqual(self.solution.numIslands([[]]), 0)

    def test_all_water(self):
        self.assertEqual(
            self.solution.numIslands(
                [
                    ["0", "0", "0"],
                    ["0", "0", "0"],
                    ["0", "0", "0"],
                ]
            ),
            0,
        )

    def test_all_land(self):
        self.assertEqual(
            self.solution.numIslands(
                [
                    ["1", "1", "1"],
                    ["1", "1", "1"],
                    ["1", "1", "1"],
                ]
            ),
            1,
        )

    def test_diagonal_islands(self):
        self.assertEqual(
            self.solution.numIslands(
                [
                    ["1", "0", "0"],
                    ["0", "1", "0"],
                    ["0", "0", "1"],
                ]
            ),
            3,
        )
        self.assertEqual(
            self.solution.numIslands(
                [
                    ["1", "0", "1"],
                    ["0", "1", "0"],
                    ["1", "0", "1"],
                ]
            ),
            5,
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
