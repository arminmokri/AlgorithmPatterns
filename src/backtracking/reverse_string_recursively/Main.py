"""
Title: Reverse a String Recursively

Description:
Implement a recursive function that takes a string as input and returns
the reversed string as output.

Example:
Input:  "hello"
Output: "olleh"

Constraints:
- Do not use built-in reverse functions (e.g., [::-1], reversed()).
- Must be solved using recursion.
"""

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

    # Time Complexity O(n^2), Space Complexity O(n)
    def reverseString(self, string: list) -> list:
        if debug:
            print()

        def backtrack(s):
            if len(s) == 0:
                return ""
            else:
                return s[-1:] + backtrack(s[:-1])

        reverse = backtrack(string)

        if debug:
            print("string='" + string + "' reverse='" + reverse + "'")

        return reverse

    # todo it has solution with Time Complexity O(n), Space Complexity O(n)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.reverseString("I Love Programming"), "gnimmargorP evoL I"
        )

    def test_empty_string(self):
        self.assertEqual(self.solution.reverseString(""), "")

    def test_single_character(self):
        self.assertEqual(self.solution.reverseString("A"), "A")

    def test_palindrome(self):
        self.assertEqual(self.solution.reverseString("madam"), "madam")

    def test_numbers_and_symbols(self):
        self.assertEqual(self.solution.reverseString("1234!@#$"), "$#@!4321")

    def test_spaces_only(self):
        self.assertEqual(self.solution.reverseString("     "), "     ")

    def test_unicode_characters(self):
        self.assertEqual(self.solution.reverseString("سلام"), "مالس")


def main():
    unittest.main()


if __name__ == "__main__":
    main()
