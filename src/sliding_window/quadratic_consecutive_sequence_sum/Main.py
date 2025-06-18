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
Input: 2030
Output:
[
    "count: 2",
    "21 22 23 24",   # 21^2 + 22^2 + 23^2 + 24^2 = 2030
    "25 26 27"       # 25^2 + 26^2 + 27^2 = 2030
]

Example 2:
Input: 50
Output:
[
    "count: 2",
    "3 4 5"          # 3^2 + 4^2 + 5^2 = 9 + 16 + 25 = 50
]

Example 3:
Input: 365
Output:
[
    "count: 2",
    "10 11 12",
    "13 14"
]
"""

import unittest

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
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def quadraticConsecutiveSequenceSum(self, x: int) -> str:
        if debug:
            print()

        if debug:
            print("x=" + str(x))

        sequences = list()

        for i in range(1, int(math.sqrt(x)) + 1):
            currentSequence = list()
            sum = 0
            for j in range(i, int(math.sqrt(x)) + 1):
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

        print("aaaa" + strSequences)

        string = '["count: ' + str(len(sequences)) + '"'
        if len(strSequences) > 0:
            string = string + ", " + strSequences
        string = string + "]"

        return string


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(2030),
            '["count: 2", "21 22 23 24", "25 26 27"]',
        )
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(50), '["count: 1", "3 4 5"]'
        )
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(365),
            '["count: 2", "10 11 12", "13 14"]',
        )

    def test_single_term(self):
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(49), '["count: 1", "7"]'
        )

    def test_two_term_sequence(self):
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(145), '["count: 1", "8 9"]'
        )

    def test_larger_sum(self):
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(4900),
            '["count: 2", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24", "70"]',
        )

    def test_no_sequence_possible(self):
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(997), '["count: 0"]'
        )

    def test_min_value(self):
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(1), '["count: 1", "1"]'
        )

    def test_non_contiguous_potential_confusion(self):
        self.assertEqual(
            self.solution.quadraticConsecutiveSequenceSum(85), '["count: 1", "6 7"]'
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
