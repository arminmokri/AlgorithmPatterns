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
    def isAnagram(self, s: str, t: str) -> bool:
        if debug:
            print()

        frequentList = [0] * 256

        for c in s:
            index = ord(c)
            frequentList[index] = frequentList[index] + 1

        for c in t:
            index = ord(c)
            frequentList[index] = frequentList[index] - 1

        isAnagram = True
        for item in frequentList:
            if not item == 0:
                isAnagram = False
                break

        if debug:
            print("s=" + s + " t=" + t + " isAnagram=" + str(isAnagram))

        return isAnagram


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertTrue(self.solution.isAnagram("listen", "silent"))

    def test_true_case(self):
        self.assertTrue(self.solution.isAnagram("listen", "silent"))
        self.assertTrue(self.solution.isAnagram("triangle", "integral"))
        self.assertTrue(self.solution.isAnagram("aabbcc", "abcabc"))

    def test_false_case(self):
        self.assertFalse(self.solution.isAnagram("hello", "bello"))
        self.assertFalse(self.solution.isAnagram("rat", "car"))
        self.assertFalse(self.solution.isAnagram("aabb", "aabbb"))

    def test_case_sensitive(self):
        self.assertFalse(self.solution.isAnagram("Listen", "silent"))

    def test_empty_strings(self):
        self.assertTrue(self.solution.isAnagram("", ""))
        self.assertFalse(self.solution.isAnagram("abc", ""))
        self.assertFalse(self.solution.isAnagram("", "abc"))

    def test_same_letters_different_lengths(self):
        self.assertFalse(self.solution.isAnagram("aabbcc", "abc"))
        self.assertFalse(self.solution.isAnagram("abc", "aabbcc"))

    def test_unicode_support(self):
        self.assertTrue(self.solution.isAnagram("éàè", "èàé"))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
