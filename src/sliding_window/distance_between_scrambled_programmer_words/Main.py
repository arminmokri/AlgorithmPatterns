"""
Title: Distance Between Scrambled Programmer Words

You are given a string that may contain one or more disordered occurrences of the word "programmer",
possibly with other characters in between. A valid "programmer" match must contain all the letters
from the word "programmer" (with correct frequency) but can be in any order and with other characters
interspersed.

Your task is to:
1. Find the leftmost substring that contains all letters of "programmer" with correct frequency.
2. Find the rightmost such substring.
3. Return the number of characters strictly between these two matching substrings.

This is a sliding window + frequency count problem.

---

Examples:

Example 1:
Input: "progrdfammerfgfdmkjfdsprogramfertmer"
Output: 10
Explanation:
- First "programmer" match starts at index 0 (inclusive)
- Second "programmer" match ends at index 43 (inclusive)
- Characters between: from index 11 to 22 → length = 10

Example 2:
Input: "xyzprogxrammerabcprogrammer123"
Output: 3
Explanation:
- First "programmer" match from index 3 to 14
- Second "programmer" match from index 18 to 29
- Characters between: from index 13 to 17 → "abc" → length = 3

Example 3:
Input: "ppprrrooggrraammmeerr"
Output: 0
Explanation:
Only one "programmer" match is present → return 0 (nothing in between)

Example 4:
Input: "somethingrandom"
Output: 0
Explanation:
"programmer" never fully appears → return 0

Constraints:
- The input string may contain lowercase letters and symbols.
- Must handle large strings efficiently.
"""

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

    def distanceBetweenWords(self, string: str) -> int:
        if debug:
            print()

        if debug:
            print("string='" + string + "'")

        programmerStr = list("programmer")
        leftPointer = 0
        if len(string) > 0:
            for i in range(0, len(string)) or not len(programmerStr) == 0:
                c = string[i]
                if c in programmerStr:
                    programmerStr.remove(c)
                    leftPointer = i

        if debug:
            print("leftPointer=" + str(leftPointer))

        programmerStr = list("programmer")
        rightPointer = 0
        if len(string) > 0:
            for i in range(len(string) - 1, 0, -1) or not len(programmerStr) == 0:
                c = string[i]
                if c in programmerStr:
                    programmerStr.remove(c)
                    rightPointer = i

        if debug:
            print("rightPointer=" + str(rightPointer))

        distance = rightPointer - leftPointer - 1
        if distance < 0:
            distance = 0

        if debug:
            print("distance=" + str(distance))

        return distance


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.distanceBetweenWords("progrdfammerfgfdmkjfdsprogramfertmer"),
            10,
        )
        self.assertEqual(
            self.solution.distanceBetweenWords("xyzprogxrammerabcprogrammer123"), 3
        )
        self.assertEqual(self.solution.distanceBetweenWords("ppprrrooggrraammmeerr"), 0)
        self.assertEqual(self.solution.distanceBetweenWords("somethingrandom"), 0)

    def test_exactly_two_programmers_with_spaces(self):
        s = "programmer" + ("-" * 15) + "programmer"
        self.assertEqual(self.solution.distanceBetweenWords(s), 15)

    def test_programmer_at_start_and_end(self):
        s = "programmerxxxxxxxmoretextyyyyyyyprogrammer"
        self.assertEqual(
            self.solution.distanceBetweenWords(s), len("xxxxxxxmoretextyyyyyyy")
        )

    def test_only_one_programmer(self):
        self.assertEqual(self.solution.distanceBetweenWords("p-r-o-g-r-a-m-m-e-r"), 0)

    def test_programmer_letters_out_of_order_with_noise(self):
        s = "rpogmarremblahblahblahprogrammer"
        self.assertEqual(self.solution.distanceBetweenWords(s), len("blahblahblah"))

    def test_multiple_occurrences(self):
        s = "xxxprogrammerxxxprogrammerxxxprogrammer"
        self.assertEqual(self.solution.distanceBetweenWords(s), 16)

    def test_case_with_duplicate_letters_but_no_valid_match(self):
        s = "ppppprrrrrooooggggrrrraaaammmmmmmeeeerrrrrr"
        self.assertEqual(self.solution.distanceBetweenWords(s), 0)

    def test_empty_string(self):
        self.assertEqual(self.solution.distanceBetweenWords(""), 0)

    def test_short_string(self):
        self.assertEqual(self.solution.distanceBetweenWords("prog"), 0)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
