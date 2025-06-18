"""
Title: Valid Anagram

Given two strings, check if the second string (B) can be constructed
using characters from the first string (A). This requires verifying
that all characters in B appear in A with at least the same frequency.

This problem can be solved efficiently using a frequency count
(hash map or array) for characters in A and B and then comparing counts.

This approach is commonly related to anagrams and substring checks.
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

    # Time Complexity O(n), Space Complexity O(1)
    def validAnagram(self, stringA: str, stringB: str) -> bool:
        if debug:
            print()

        frequentList = [0] * 256

        for c in stringA:
            index = ord(c)
            frequentList[index] = frequentList[index] + 1

        for c in stringB:
            index = ord(c)
            frequentList[index] = frequentList[index] - 1

        isAnagram = True
        for item in frequentList:
            if not item == 0:
                isAnagram = False
                break

        if debug:
            print(
                "stringA="
                + stringA
                + " stringB="
                + stringB
                + " isAnagram="
                + str(isAnagram)
            )

        return isAnagram


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertTrue(self.solution.validAnagram("listen", "silent"))

    def test_true_case(self):
        self.assertTrue(self.solution.validAnagram("listen", "silent"))
        self.assertTrue(self.solution.validAnagram("triangle", "integral"))
        self.assertTrue(self.solution.validAnagram("aabbcc", "abcabc"))

    def test_false_case(self):
        self.assertFalse(self.solution.validAnagram("hello", "bello"))
        self.assertFalse(self.solution.validAnagram("rat", "car"))
        self.assertFalse(self.solution.validAnagram("aabb", "aabbb"))

    def test_case_sensitive(self):
        self.assertFalse(self.solution.validAnagram("Listen", "silent"))

    def test_empty_strings(self):
        self.assertTrue(self.solution.validAnagram("", ""))
        self.assertFalse(self.solution.validAnagram("abc", ""))
        self.assertFalse(self.solution.validAnagram("", "abc"))

    def test_same_letters_different_lengths(self):
        self.assertFalse(self.solution.validAnagram("aabbcc", "abc"))
        self.assertFalse(self.solution.validAnagram("abc", "aabbcc"))

    def test_unicode_support(self):
        self.assertTrue(self.solution.validAnagram("éàè", "èàé"))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
