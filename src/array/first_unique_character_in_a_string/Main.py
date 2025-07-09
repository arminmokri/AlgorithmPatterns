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

    def firstUniqueCharacter(self, string: str) -> int:
        if debug:
            print()

        singleIndex = None

        frequentList = [0] * 256

        if debug:
            print("frequentList=" + str(frequentList))

        for c in string:
            frequentIndex = ord(c)
            frequentList[frequentIndex] = frequentList[frequentIndex] + 1

        if debug:
            print("frequentList=" + str(frequentList))

        for i, c in enumerate(string):
            frequentIndex = ord(c)
            if frequentList[frequentIndex] == 1:
                singleIndex = i
                break

        return singleIndex


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.firstUniqueCharacter("stress"),
            1,
        )

    def test_no_unique_character(self):
        self.assertIsNone(self.solution.firstUniqueCharacter("aabbcc"))

    def test_first_character_unique(self):
        self.assertEqual(self.solution.firstUniqueCharacter("abcdef"), 0)

    def test_last_character_unique(self):
        self.assertEqual(self.solution.firstUniqueCharacter("aabbccd"), 6)

    def test_empty_string(self):
        self.assertIsNone(self.solution.firstUniqueCharacter(""))

    def test_all_unique_characters(self):
        self.assertEqual(self.solution.firstUniqueCharacter("abcde"), 0)

    def test_single_character(self):
        self.assertEqual(self.solution.firstUniqueCharacter("z"), 0)

    def test_mixed_case(self):
        self.assertEqual(self.solution.firstUniqueCharacter("AaBbCcD"), 0)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
