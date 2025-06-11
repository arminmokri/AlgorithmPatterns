"""
Tilte: Lucy’s Spiral Hop (Anti-Clockwise Skip Spiral)

Lucy starts from cell (0,0) in a 2D matrix and moves in an anti-clockwise spiral pattern,
skipping every alternate cell. The goal is to determine the value of the last cell she hops onto.

Movement pattern:
- Anti-clockwise spiral (left → down → right → up)
- Skip every alternate cell (hop on, skip next, hop on, etc.)

Approach:
- Simulate anti-clockwise spiral traversal
- Maintain a skip flag to alternate between hopping and skipping
- Track visited cells to avoid revisiting
- Record only the hopped cells, return the last one

Time Complexity: O(N * M) — each cell is visited at most once
Space Complexity: O(N * M) for visited tracking
"""

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

    def Solution(self, matrix: list[list[int]]) -> int:
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


def main():
    matrix = [[29, 8, 37], [15, 41, 3], [1, 10, 14]]
    solution = Solution()
    result = solution.Solution(matrix)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
