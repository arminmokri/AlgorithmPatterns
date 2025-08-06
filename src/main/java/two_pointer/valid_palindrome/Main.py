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

    def isPalindrome(self, s: str) -> bool:
        if debug:
            print()

        left = 0
        right = len(s) - 1

        is_palindrome = True
        while left < right:
            if not s[left].isalpha():
                left = left + 1
            elif not s[right].isalpha():
                right = right - 1
            else:
                if not s[left].lower() == s[right].lower():
                    is_palindrome = False
                    break
                left = left + 1
                right = right - 1

        if debug:
            print("s='" + s + "' is_palindrome=" + str(is_palindrome))

        return is_palindrome


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertTrue(self.solution.isPalindrome("A man, a plan, a canal: Panama"))
        self.assertFalse(self.solution.isPalindrome("race a car"))
        self.assertTrue(self.solution.isPalindrome(" "))

    def test_empty_string(self):
        self.assertTrue(self.solution.isPalindrome(""))

    def test_single_character(self):
        self.assertTrue(self.solution.isPalindrome("a"))

    def test_only_non_alphabetic(self):
        self.assertTrue(self.solution.isPalindrome("!!!???"))  # Only ignored characters

    def test_case_insensitivity(self):
        self.assertTrue(self.solution.isPalindrome("Aa"))

    def test_mixed_characters(self):
        self.assertTrue(self.solution.isPalindrome("No 'x' in Nixon"))

    def test_with_numbers_and_letters(self):
        self.assertTrue(self.solution.isPalindrome("1a2!a1"))

    def test_not_palindrome(self):
        self.assertFalse(self.solution.isPalindrome("Hello, world!"))

    def test_long_palindrome(self):
        s = "Able was I ere I saw Elba"
        self.assertTrue(self.solution.isPalindrome(s))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
