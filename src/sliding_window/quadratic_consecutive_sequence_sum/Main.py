"""
Title: Quadratic Consecutive Sequence Sum

Given an integer `x`, find all sequences of the form:
    n^2 + (n+1)^2 + (n+2)^2 + ... + (n+m)^2 = x
Return all possible values of `n` where the equation holds for some m >= 0.

Input:
    - A single integer x (1 <= x <= 10^9)

Output:
    - An array of strings:
        - First element: "count: <number of valid sequences>"
        - Next lines: space-separated sequences of values (e.g., "3 4 5")

Example 1:
Input: 50
Output:
[
    "count: 2",
    "3 4",          # 3^2 + 4^2 = 9 + 16 = 25
    "0 1 2 3"       # 0^2 + 1^2 + 2^2 + 3^2 = 0 + 1 + 4 + 9 = 14 (invalid)
]

Example 2:
Input: 365
Output:
[
    "count: 1",
    "10 11 12"
]
"""

import math

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

    def Solution(self, x: int) -> str:
        sequences = list()

        for i in range(1, int(math.sqrt(x))):
            currentSequence = list()
            sum = 0
            for j in range(i, int(math.sqrt(x))):
                sum = sum + (j**2)
                currentSequence.append(j)
                if sum == x:
                    sequences.append(currentSequence)
                    break
                elif sum > x:
                    break

        if debug:
            print("sequence=\n" + self.martixToString(sequences))

        strSequences = ", ".join(
            '"' + " ".join(str(val) for val in row) + '"' for row in sequences
        )

        string = '["count: ' + str(len(sequences))
        if len(strSequences) > 0:
            string = string + '", ' + strSequences
        string = string + "]"

        return string


def main():
    x = 2030
    solution = Solution()
    result = solution.Solution(x)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
