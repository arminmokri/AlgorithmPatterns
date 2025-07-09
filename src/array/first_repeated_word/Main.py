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

    def firstRepeatedWord(self, text: str) -> str:
        if debug:
            print()

        firstRepeated = ""

        words = text.split()

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
