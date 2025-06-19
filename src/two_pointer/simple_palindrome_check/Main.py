"""
Title: Simple Palindrome Check

Check if the input string is symmetrical (a palindrome), meaning it reads the same forwards and backwards exactly,
without ignoring spaces, cases, or punctuation.

The two-pointer approach compares characters from the start and end moving toward the center.
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

    # Time Complexity O(n), Space Complexity O(1)
    def palindromeCheck(self, string: str) -> bool:
        if debug:
            print()

        if debug:
            print("string=" + string)

        isPalindrome = True

        for i in range(0, int(len(string) / 2)):
            leftChar = string[i]
            rightChar = string[len(string) - (i + 1)]
            if not leftChar == rightChar:
                isPalindrome = False
                break

        if debug:
            print("isPalindrome=" + str(isPalindrome))

        return isPalindrome


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertTrue(self.solution.palindromeCheck("racecar"))

    def test_simple_palindromes(self):
        self.assertTrue(self.solution.palindromeCheck("madam"))
        self.assertTrue(self.solution.palindromeCheck("a"))

    def test_empty_string(self):
        self.assertTrue(self.solution.palindromeCheck(""))

    def test_two_characters(self):
        self.assertTrue(self.solution.palindromeCheck("aa"))
        self.assertFalse(self.solution.palindromeCheck("ab"))

    def test_even_length_palindromes(self):
        self.assertTrue(self.solution.palindromeCheck("abba"))
        self.assertTrue(self.solution.palindromeCheck("deed"))

    def test_not_palindromes(self):
        self.assertFalse(self.solution.palindromeCheck("hello"))
        self.assertFalse(self.solution.palindromeCheck("palindrome"))

    def test_case_sensitive(self):
        self.assertFalse(self.solution.palindromeCheck("Racecar"))

    def test_with_spaces(self):
        self.assertFalse(self.solution.palindromeCheck("nurses run"))
        self.assertTrue(self.solution.palindromeCheck("a b b a"))

    def test_with_punctuation(self):
        self.assertFalse(self.solution.palindromeCheck("madam!"))

    def test_long_palindrome(self):
        self.assertTrue(self.solution.palindromeCheck("abcdedcba"))
        self.assertFalse(self.solution.palindromeCheck("abcdedcbz"))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
