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

    def longestCommonPrefix(self, strs: List[str]) -> str:
        if debug:
            print()

        biggestPrefix = ""
        minStr = min(strs, key=len) if len(strs) > 0 else ""

        for i in range(len(minStr), 0, -1):
            prefixStr = minStr[0:i]

            if debug:
                print("prefixStr=" + prefixStr)

            flag = 0
            for currentStr in strs:
                if minStr == currentStr:
                    continue

                if not currentStr.startswith(prefixStr):
                    flag = 1
                    break

            if flag == 0:
                biggestPrefix = prefixStr
                break

        return biggestPrefix


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.longestCommonPrefix(["flower", "flow", "flight"]), "fl"
        )
        self.assertEqual(
            self.solution.longestCommonPrefix(["dog", "racecar", "car"]), ""
        )

    def test_single_word(self):
        self.assertEqual(self.solution.longestCommonPrefix(["alone"]), "alone")

    def test_identical_words(self):
        self.assertEqual(
            self.solution.longestCommonPrefix(["same", "same", "same"]), "same"
        )

    def test_empty_list(self):
        self.assertEqual(self.solution.longestCommonPrefix([]), "")

    def test_list_with_empty_string(self):
        self.assertEqual(self.solution.longestCommonPrefix(["", "abc", "ab"]), "")

    def test_no_common_prefix(self):
        self.assertEqual(self.solution.longestCommonPrefix(["abc", "def", "ghi"]), "")

    def test_full_prefix_match(self):
        self.assertEqual(
            self.solution.longestCommonPrefix(["interview", "intervene", "internal"]),
            "inter",
        )

    def test_numeric_string_prefix(self):
        self.assertEqual(
            self.solution.longestCommonPrefix(["12345", "123", "123abc"]), "123"
        )

    def test_case_sensitive(self):
        self.assertEqual(
            self.solution.longestCommonPrefix(["Case", "case", "cast"]), ""
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
