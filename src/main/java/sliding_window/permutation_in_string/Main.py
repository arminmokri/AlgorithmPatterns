from typing import List, Tuple
import unittest

debug = True


class Solution:
    def matrixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
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

    def checkInclusion(self, s1: str, s2: str) -> bool:
        def makeFrequentMap(s: str) -> dict:
            frequent_map = dict()
            for c in s:
                if c not in frequent_map:
                    frequent_map[c] = 1
                else:
                    frequent_map[c] = frequent_map[c] + 1
            return frequent_map

        if debug and len(s2) < 20:
            print()

        s1_frequent_map = makeFrequentMap(s1)

        if debug and len(s2) < 20:
            print("s1_frequent_map=" + str(s1_frequent_map))

        isInclusion = False

        for i in range(0, len(s2) - len(s1) + 1):
            sub_s2 = s2[i : i + len(s1)]

            sub_s2_frequent_map = makeFrequentMap(sub_s2)

            if debug and len(s2) < 20:
                print(
                    "sub_s2="
                    + sub_s2
                    + " sub_s2_frequent_map="
                    + str(sub_s2_frequent_map)
                )

            if sub_s2_frequent_map == s1_frequent_map:
                isInclusion = True
                break

        return isInclusion


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertTrue(self.solution.checkInclusion("ab", "eidbaooo"))
        self.assertFalse(self.solution.checkInclusion("ab", "eidboaoo"))

    def test_empty_strings(self):
        self.assertTrue(self.solution.checkInclusion("", ""))
        self.assertTrue(self.solution.checkInclusion("", "abc"))
        self.assertFalse(self.solution.checkInclusion("a", ""))

    def test_exact_match(self):
        self.assertTrue(self.solution.checkInclusion("abc", "abc"))

    def test_no_match(self):
        self.assertFalse(self.solution.checkInclusion("abc", "defghijk"))

    def test_multiple_occurrences(self):
        self.assertTrue(self.solution.checkInclusion("abc", "defbacghiabc"))
        self.assertTrue(self.solution.checkInclusion("abc", "zzzcbazzz"))

    def test_single_character(self):
        self.assertTrue(self.solution.checkInclusion("a", "a"))
        self.assertTrue(self.solution.checkInclusion("a", "xyzabc"))
        self.assertFalse(self.solution.checkInclusion("z", "abcabc"))

    def test_case_sensitivity(self):
        self.assertTrue(self.solution.checkInclusion("a", "Aabc"))
        self.assertFalse(self.solution.checkInclusion("ab", "AB"))

    def test_long_strings(self):
        s1 = "abc"
        s2 = "x" * 1000 + "cab" + "y" * 1000
        self.assertTrue(self.solution.checkInclusion(s1, s2))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
