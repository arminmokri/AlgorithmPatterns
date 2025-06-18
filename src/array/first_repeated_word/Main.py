"""
Title: First Repeated Word

Given a string containing space-separated words, return the first word that is repeated.
If there is no repetition, return an empty string.

Approach:
- Split the input string by spaces to extract individual words.
- Use a set to track seen words while iterating.
- Return the first word that is already in the set.
- If no repetition is found, return "".

Example:
Input:  "alpha beta gamma alpha delta beta"
Output: "alpha"
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

    def firstRepeatedWord(self, string: str) -> str:
        if debug:
            print()

        firstRepeated = ""

        words = string.split()

        repeated = set()

        for word in words:
            word = word.strip().lower()
            if word in repeated:
                firstRepeated = word
                break
            repeated.add(word)

        return firstRepeated


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.firstRepeatedWord("alpha beta gamma alpha delta beta"),
            "alpha",
        )

    def test_no_repeats(self):
        self.assertEqual(self.solution.firstRepeatedWord("apple banana cherry"), "")

    def test_repeats_immediately(self):
        self.assertEqual(self.solution.firstRepeatedWord("one one two three"), "one")

    def test_case_sensitive(self):
        self.assertEqual(self.solution.firstRepeatedWord("Dog dog DOG"), "dog")

    def test_trailing_and_leading_spaces(self):
        self.assertEqual(
            self.solution.firstRepeatedWord("  this  is   a test this is"), "this"
        )

    def test_only_one_word(self):
        self.assertEqual(self.solution.firstRepeatedWord("hello"), "")

    def test_empty_string(self):
        self.assertEqual(self.solution.firstRepeatedWord(""), "")

    def test_all_repeated(self):
        self.assertEqual(self.solution.firstRepeatedWord("x x x x x"), "x")


def main():
    unittest.main()


if __name__ == "__main__":
    main()
